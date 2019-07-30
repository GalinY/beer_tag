package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.User;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
   private SessionFactory sessionFactory;


    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public User getById(long user_id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, user_id);
    }
    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        } catch (HibernateError he) {
            System.out.println(he.getMessage());
            throw he;
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String query = "from User as u " +
                    "where  u.username = :username";
            Query q = session.createQuery(query).setParameter("username", username);
            user = (User) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User as u where u.eMail like :email", User.class);
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getByName(String first_name) {
        List<User> usersByName=new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String query = "from User as u " +
                    "where  u.firstName = :first_name";
            Query q = session.createQuery(query).setParameter("first_name", first_name);
            usersByName = q.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return usersByName;

    }

    @Override
    public User updateFirstName(long user_id, String firstName) {
        Session session = sessionFactory.getCurrentSession();
        User user=getById(user_id);
        user.setFirstName(firstName);
        Query query = session.createQuery("UPDATE User SET firstName = :firstName WHERE user_id=:user_id");
        query.setParameter("user_id", user_id);
        query.setParameter("firstName", firstName);
        query.executeUpdate();
        return (User) query.getSingleResult();

    }

    @Override
    public User updateLastName(long user_id, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        User user=getById(user_id);
        user.setLastName(lastName);
        Query query = session.createQuery("UPDATE User SET lastName = :lastName WHERE user_id=:user_id");
        query.setParameter("user_id", user_id);
        query.setParameter("lastName", lastName);
        query.executeUpdate();
        return (User) query.getSingleResult();
    }

    @Override
    public User updateEmail(long user_id, String eMail) {
        Session session = sessionFactory.getCurrentSession();
        User user=getById(user_id);
        user.seteMail(eMail);
        Query query = session.createQuery("UPDATE User SET eMail = :eMail WHERE user_id=:user_id");
        query.setParameter("user_id", user_id);
        query.setParameter("eMail", eMail);
        int result = query.executeUpdate();
        return (User) query.getSingleResult();
    }

    @Override
    public User updatePassword(long user_id, String password) {
        Session session = sessionFactory.getCurrentSession();
        User user=getById(user_id);
        user.setPassword(password);
        Query query = session.createQuery("UPDATE User SET password = :password WHERE user_id=:user_id");
        query.setParameter("user_id", user_id);
        query.setParameter("password", password);
        query.executeUpdate();
        return (User) query.getSingleResult();
    }


    @Override
    public User updateUserName(long user_id, String userName) {
        Session session = sessionFactory.getCurrentSession();
        User user=getById(user_id);
        user.setUsername(userName);
        Query query = session.createQuery("UPDATE User SET username = :userName WHERE user_id=:user_id");
        query.setParameter("user_id", user_id);
        query.setParameter("userName", userName);
        query.executeUpdate();
        return (User) query.getSingleResult();
    }


    @Override
    public void delete(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete User as b where b.user_id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create(User user) {
    	try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


}

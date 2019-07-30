package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Role loadUserRightsByUserRightsName(String name) {
        Role userRole = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String query = "from Role as u where  u.role_name = :name";
            Query q = session.createQuery(query).setParameter("name", name);
            userRole = (Role) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return userRole;
    }
}

package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreweryRepositoryImpl implements BreweryRepository {
    private SessionFactory sessionFactory;

    @Autowired

    public BreweryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Brewery getById(long brewery_id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Brewery.class, brewery_id);
    }
    @Override
    public Brewery create(Brewery brewery) {
        Session session = sessionFactory.getCurrentSession();
        session.save(brewery);
        return brewery;
    }

    @Override
    public void delete(long brewery_id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete Brewery as b where b.brewery_id =:brewery_id");
            query.setParameter("brewery_id", brewery_id);
            query.executeUpdate();
//            TODO RETURN A HTTP RESPONSE MESSAGE
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Brewery> getAllBrewery() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Brewery", Brewery.class)
                .list();
    }

    @Override
    public Brewery updateName(long brewery_id, String name) {
        Session session=sessionFactory.getCurrentSession();
        Brewery brewery=getById(brewery_id);
        brewery.setName(name);
        Query query = session.createQuery("UPDATE Brewery SET name = :name WHERE brewery_id = :brewery_id");
        query.setParameter("name", name);
        query.setParameter("brewery_id", brewery_id);
        int result = query.executeUpdate();
        return brewery;

    }

    @Override
    public Brewery updateCountry(long brewery_id, OriginCountry country) {
        Session session=sessionFactory.getCurrentSession();
        Brewery brewery=getById(brewery_id);
        brewery.setCountry(country);
        Query query = session.createQuery("UPDATE Brewery SET country.country_id = :country_id WHERE brewery_id = :brewery_id");
        query.setParameter("country_id", country.getCountry_id());
        query.setParameter("brewery_id", brewery_id);
        int result = query.executeUpdate();
        return brewery;
    }
}

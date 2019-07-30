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
public class OriginCountryRepositoryImpl implements OriginCountryRepository {
    private SessionFactory sessionFactory;

    @Autowired

    public OriginCountryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public OriginCountry getById(long country_id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(OriginCountry.class, country_id);
    }

    @Override
    public OriginCountry create(OriginCountry country) {
        Session session = sessionFactory.getCurrentSession();
        session.save(country);
        return country;
    }

    @Override
    public void delete(long country_id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE OriginCountry AS oc WHERE oc.country_id =:country_id");
            query.setParameter("country_id", country_id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OriginCountry> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from OriginCountry ", OriginCountry.class)
                .list();
    }

    @Override
    public OriginCountry updateName(long country_id, String name) {
        Session session=sessionFactory.getCurrentSession();
        OriginCountry country=getById(country_id);
        country.setName(name);
        Query query = session.createQuery("UPDATE OriginCountry SET name = :name WHERE country_id = :country_id");
        query.setParameter("name", name);
        query.setParameter("country_id", country_id);
        int result = query.executeUpdate();
        return (OriginCountry) query.getSingleResult();
    }

    @Override
    public OriginCountry updateBrewery(long country_id, Brewery brewery) {
        Session session=sessionFactory.getCurrentSession();
        OriginCountry country=getById(country_id);
        country.setBrewery(brewery);
        Query query = session.createQuery("UPDATE OriginCountry SET brewery.brewery_id = :brewery_id WHERE country_id = :country_id");
        query.setParameter("brewery_id", brewery.getId());
        query.setParameter("country_id", country_id);
        int result = query.executeUpdate();
        return (OriginCountry) query.getSingleResult();
    }
}

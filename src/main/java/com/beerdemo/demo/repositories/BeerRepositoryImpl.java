package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BeerRepositoryImpl implements BeerRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public BeerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public List<Beer> getAllBeers() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Beer", Beer.class)
                .list();
    }

    @Override
    public Beer getByID(long beer_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Beer.class, beer_id);
    }

    public List<Beer> getByName(String beer_name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Beer> query = session.createQuery("from Beer where beer_name  like :beer_name", Beer.class);
            query.setParameter("beer_name", "%" + beer_name + "%");
            if (query.list().isEmpty()) {
                throw new RuntimeException();
            } else {
                return query.getResultList();
            }
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            throw he;
        }
    }


    @Override
    public List<Beer> sortAlphabetical() {
        List<Beer> beers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "from Beer as br ORDER BY br.beer_name ";
            Query query = session.createQuery(hql, Beer.class);
            beers = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beers;
    }

    @Override
    public List<Beer> filterByCountry(String country) {
        List<Beer> beers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "FROM Beer as br WHERE br.country.name like :country";
            Query query = session.createQuery(hql, Beer.class);
            query.setParameter("country", country);
            beers = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beers;
    }

    @Override
    public List<Beer> sortByRating() {
        List<Beer> beers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "from Beer as br ORDER BY br.rating";
            Query query = session.createQuery(hql, Beer.class);
            beers = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beers;
    }

    @Override
    public Beer updateName(long beer_id, String beer_name) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setBeer_name(beer_name);
        Query query = session.createQuery("UPDATE Beer SET beer_name = :beer_name WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("beer_name", beer_name);
        int result = query.executeUpdate();
        return beer;

    }

    @Override
    public Beer updateABV(long beer_id, double ABV) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setABV(ABV);
        Query query = session.createQuery("UPDATE Beer SET ABV = :ABV WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("ABV", ABV);
        int result = query.executeUpdate();
        return (Beer) query.getSingleResult();
    }

    @Override
    public Beer updateCountry(long beer_id, OriginCountry originCountry) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setCountry(originCountry);
        Query query = session.createQuery("UPDATE Beer SET country.country_id = :country_id WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("country_id", originCountry.getCountry_id());
        int result = query.executeUpdate();
        return (Beer) query.getSingleResult();


    }

    @Override
    public Beer updateDescription(long beer_id, String description) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setDescription(description);
        Query query = session.createQuery("UPDATE Beer SET description = :description WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("description", description);
        int result = query.executeUpdate();
        return (Beer) query.getSingleResult();
    }

    @Override
    public Beer updateBrewery(long beer_id, Brewery brewery) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setBrewery(brewery);
        Query query = session.createQuery("UPDATE Beer SET brewery.brewery_id = :brewery_id WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("brewery_id", brewery.getId());
        int result = query.executeUpdate();
        return (Beer) query.getSingleResult();

    }

    @Override
    public Beer updateStyle(long beer_id, BeerStyle beerStyle) {
        Session session = sessionFactory.getCurrentSession();
        Beer beer = getByID(beer_id);
        beer.setStyle(beerStyle);
        Query query = session.createQuery("UPDATE Beer SET style.style_id = :style_id WHERE beer_id = :beer_id");
        query.setParameter("beer_id", beer_id);
        query.setParameter("style_id", beerStyle.getStyle_id());
        int result = query.executeUpdate();
        return (Beer) query.getSingleResult();
    }


    @Override
    public Beer create(Beer beer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(beer);
        return beer;

    }

    @Override
    public void delete(long beer_id) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete Beer as b where b.beer_id =:beer_id");
            query.setParameter("beer_id", beer_id);
            query.executeUpdate();
//            TODO RETURN A HTTP RESPONSE MESSAGE
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Beer> sortByABV() {
        List<Beer> beers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "from Beer as br ORDER BY br.ABV desc";
            Query query = session.createQuery(hql, Beer.class);
            beers = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beers;
    }

    @Override
    public List<Beer> filterByStyle(String style) {

        List<Beer> beers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "FROM Beer as br where  br.style.name like :style";

            Query query = session.createQuery(hql, Beer.class);
            query.setParameter("style", style);
            beers = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beers;
    }

    @Override
    public List<Beer> filterByTags(String tag) {

        List<Beer> beers;
        beers = getAllBeers().stream()
                             .filter(t -> t.getTags()
                                           .stream().anyMatch(ts -> ts.getName()
                                                                      .equals(tag)))
                             .collect(Collectors.toList());

        return beers;
    }


    @Override
    public Beer updateRating(double rating, int id) {
        Beer beer = getByID(id);
        beer.setRating(rating);
        return beer;
    }

//    @Override
//    public Beer updateBeer(long beer_id, Beer beer) {
//        Session session = sessionFactory.getCurrentSession();
//        Beer beer = getByID(beer_id);
//        beer.setBrewery(brewery);
//        Query query = session.createQuery("UPDATE Beer SET brewery.brewery_id = :brewery_id WHERE beer_id =
//        :beer_id");
//        query.setParameter("beer_id", beer_id);
//        query.setParameter("brewery_id", brewery.getId());
//        int result = query.executeUpdate();
//        return (Beer) query.getSingleResult();
//    }
}

package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.BeerStyle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeerStyleRepositoryImpl implements BeerStyleRepository {
    SessionFactory sessionFactory;

    @Autowired
    public BeerStyleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BeerStyle> getAllStyles() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from BeerStyle ", BeerStyle.class)
                .list();
    }
}


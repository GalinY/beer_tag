package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {
    private SessionFactory sessionFactory;
    @Autowired
    public TagRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Tag> getAllTags() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Tag ", Tag.class)
                .list();
    }

}

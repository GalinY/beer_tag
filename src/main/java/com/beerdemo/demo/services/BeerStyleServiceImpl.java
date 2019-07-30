package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.repositories.BeerStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerStyleServiceImpl implements BeerStyleService {
    BeerStyleRepository repository;

    @Autowired
    public BeerStyleServiceImpl(BeerStyleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BeerStyle> getAllStyles() {
        return repository.getAllStyles();
    }
}

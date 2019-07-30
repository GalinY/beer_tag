package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService {
    BreweryRepository repository;

    @Autowired
    public BreweryServiceImpl(BreweryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Brewery create(Brewery brewery){
       return repository.create(brewery);
    }

    @Override
    public void delete(long brewery_id) {
        repository.delete(brewery_id);
    }

    @Override
    public List<Brewery> getAllBrewery() {
        return repository.getAllBrewery();
    }

    @Override
    public Brewery updateName(long brewery_id, String brewery) {
        return repository.updateName(brewery_id,brewery);
    }

    @Override
    public Brewery updateCountry(long brewery_id, OriginCountry country) {
        return repository.updateCountry(brewery_id, country);
    }
}

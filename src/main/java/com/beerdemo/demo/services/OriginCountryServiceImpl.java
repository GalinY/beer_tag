package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.OriginCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginCountryServiceImpl implements OriginCountryService {
    OriginCountryRepository repository;

    @Autowired

    public OriginCountryServiceImpl(OriginCountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public OriginCountry create(OriginCountry country) {
        return repository.create(country);
    }

    @Override
    public void delete(long country_id) {
        repository.delete(country_id);
    }

    @Override
    public List<OriginCountry> getAllCountries() {
        return repository.getAllCountries();
    }

    @Override
    public OriginCountry updateName(long country_id, String name) {
        return repository.updateName(country_id, name);
    }

    @Override
    public OriginCountry updateBrewery(long country_id, Brewery brewery) {
       return repository.updateBrewery(country_id, brewery);
    }
}

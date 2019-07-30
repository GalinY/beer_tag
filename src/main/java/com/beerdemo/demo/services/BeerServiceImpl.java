package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BeerServiceImpl implements BeerService {
    private BeerRepository repository;

    @Autowired
    public BeerServiceImpl(BeerRepository repository) {
        this.repository = repository;
    }

    public List<Beer> getAllBeers() {
        return repository.getAllBeers();

    }

    @Override
    public Beer getBeerByID(long beer_id) {
        Beer beer = repository.getByID(beer_id);
        if (beer == null) {
            throw new IllegalArgumentException(String.format("Beer with id %s was not found.", beer_id));
        }
        return beer;
    }

    @Override
    public List<Beer> getByName(String name) {

        return repository.getByName(name);
    }

    @Override
    public Beer create(Beer beer) {
        return repository.create(beer);
    }

    @Override
    public Beer updateName(long beer_id, String beer_name) {
        return repository.updateName(beer_id, beer_name);
    }

    @Override
    public Beer updateABV(long beer_id, double ABV) {
        return repository.updateABV(beer_id, ABV);
    }

    @Override
    public Beer updateCountry(long beer_id, OriginCountry country) {
        return repository.updateCountry(beer_id, country);
    }

    @Override
    public Beer updateDescription(long beer_id, String description) {
        return repository.updateDescription(beer_id, description);
    }

    @Override
    public Beer updateBrewery(long beer_id, Brewery brewery) {
        return repository.updateBrewery(beer_id, brewery);
    }

    @Override
    public Beer updateStyle(long beer_id, BeerStyle beerStyle) {
        return repository.updateStyle(beer_id, beerStyle);
    }

    @Override
    public void delete(long beer_id) {
        repository.delete(beer_id);
    }

    @Override
    public List<Beer> filterByCountry(String country) {
        return repository.filterByCountry(country);
    }

    @Override
    public Beer updateRating(double rating, int id) {
        return repository.updateRating(rating, id);
    }


    @Override
    public List<Beer> sortAlphabetical() {
        return repository.sortAlphabetical();
    }

    @Override
    public List<Beer> sortByRating() {
        return repository.sortByRating();
    }

    @Override
    public List<Beer> filterByStyle(String style) {
        return repository.filterByStyle(style);
    }

    @Override
    public List<Beer> sortByABV() {
        return repository.sortByABV();
    }

    @Override
    public List<Beer> filterByTag(String tag) {
        return repository.filterByTags(tag);
    }
}

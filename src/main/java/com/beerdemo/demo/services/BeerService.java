package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;

import java.util.List;

public interface BeerService {

    List<Beer> getAllBeers();


    Beer getBeerByID(long beer_id);


    List<Beer> getByName(String name);

    Beer create(Beer beer);

    //void update(long beer_id, String beer_name, double ABV, long country_id, String description, long brewery_id,
    // long style_id);

    Beer updateName(long beer_id, String beer_name);

    Beer updateABV(long beer_id, double ABV);

    Beer updateCountry(long beer_id, OriginCountry country);

    Beer updateDescription(long beer_id, String description);

    Beer updateBrewery(long beer_id, Brewery brewery);

    Beer updateStyle(long beer_id, BeerStyle style);

    void delete(long beer_id);

    List<Beer> filterByCountry(String country);

    Beer updateRating(double rating, int id);

    List<Beer> sortAlphabetical();

    List<Beer> sortByRating();

    List<Beer> filterByStyle(String style);

    List<Beer> sortByABV();

    List<Beer> filterByTag(String tag);

}
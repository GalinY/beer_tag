package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;

import java.util.List;

public interface BeerRepository {
    List<Beer> sortAlphabetical();

    List<Beer> filterByCountry(String country);

    List<Beer> sortByRating();

    Beer updateName(long beer_id, String beer_name);

    Beer updateABV(long beer_id, double ABV);

    Beer updateCountry(long beer_id, OriginCountry origincountry);

    Beer updateDescription(long beer_id, String description);

    Beer updateBrewery(long beer_id, Brewery brewery);

    Beer updateStyle(long beer_id, BeerStyle beerStyle);

    Beer create(Beer beer);

    void delete(long beer_id);

    List<Beer> getAllBeers();

    Beer getByID(long beer_id);

    List<Beer> getByName(String name);

    List<Beer> sortByABV();

    List<Beer> filterByStyle(String style);

    List<Beer> filterByTags(String tag);

    Beer updateRating(double rating, int id);

//    Beer updateBeer(long beer_id, Beer beer);
}

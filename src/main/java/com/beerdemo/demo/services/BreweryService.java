package com.beerdemo.demo.services;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;

import java.util.List;

public interface BreweryService {

    Brewery create(Brewery brewery);

    void delete(long brewery_id);

    List<Brewery> getAllBrewery();

    Brewery updateName(long brewery_id,String brewery);

    Brewery updateCountry(long brewery_id, OriginCountry country);
}

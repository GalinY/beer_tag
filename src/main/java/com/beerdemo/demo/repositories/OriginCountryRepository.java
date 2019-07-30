package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;

import java.util.List;

public interface OriginCountryRepository {

    OriginCountry getById(long country_id);

    OriginCountry create(OriginCountry country);

    void delete(long brewery_id);

    List<OriginCountry> getAllCountries();

    OriginCountry updateName(long country_id, String country);

    OriginCountry updateBrewery(long country_id, Brewery brewery);
}

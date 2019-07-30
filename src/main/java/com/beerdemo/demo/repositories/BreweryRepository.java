package com.beerdemo.demo.repositories;


import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;

import java.util.List;

public interface BreweryRepository {

    Brewery getById(long brewery_id);

    Brewery create(Brewery brewery);

    void delete(long brewery_id);

    List<Brewery> getAllBrewery();

    Brewery updateName(long brewery_id,String brewery);

    Brewery updateCountry(long brewery_id, OriginCountry originCountry);

}

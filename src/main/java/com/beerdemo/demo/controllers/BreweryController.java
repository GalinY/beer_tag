package com.beerdemo.demo.controllers;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.BeerRepository;
import com.beerdemo.demo.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@RestController
@RequestMapping("/api/breweries")
public class BreweryController {
    private BreweryService service;

    @Autowired
    public BreweryController(BreweryService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public Brewery create(@RequestBody Brewery brewery) {
        return service.create(brewery);
    }

    @DeleteMapping("/{brewery_id}")
    public void delete(@PathVariable long brewery_id) {
        service.delete(brewery_id);
    }

    @GetMapping
    public List<Brewery> getAllBrewery() {
        return service.getAllBrewery();
    }

    @PostMapping("/update/name/{brewery_id}/{brewery_name}")
    public Brewery updateName(@PathVariable long brewery_id,@PathVariable String brewery_name) {
        return service.updateName(brewery_id, brewery_name);
    }

    @PostMapping("/update/country/{brewery_id}/{country_id}")
    public Brewery updateCountry(@PathVariable long brewery_id, @RequestBody OriginCountry originCountry) {
        return service.updateCountry(brewery_id, originCountry);
    }
}


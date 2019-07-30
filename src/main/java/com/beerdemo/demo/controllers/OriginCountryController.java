package com.beerdemo.demo.controllers;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.services.OriginCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class OriginCountryController {
    private OriginCountryService service;

    @Autowired
    public OriginCountryController(OriginCountryService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public OriginCountry create(@RequestBody OriginCountry country){
        return service.create(country);
    }

    @DeleteMapping("/{country_id}")
    public void delete(@PathVariable long country_id) {
        service.delete(country_id);
    }

    @GetMapping
    public List<OriginCountry> getAllCountries() {
        return service.getAllCountries();
    }

    @PostMapping("/update/name/{country_id}/{country_name}")
    public OriginCountry updateName(@PathVariable long country_id, @PathVariable String country_name) {
        return service.updateName(country_id, country_name);
    }
    @PostMapping("/update/brewery/{country_id}/brewery")
    public OriginCountry updateBrewery(@PathVariable long country_id, @RequestBody Brewery brewery) {
        return service.updateBrewery(country_id, brewery);
    }
}

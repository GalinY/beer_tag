package com.beerdemo.demo.controllers;

import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.services.BeerStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/styles")
public class BeerStyleController {

    private BeerStyleService service;

    @Autowired
    public BeerStyleController(BeerStyleService service) {
        this.service = service;
    }

    @GetMapping
    public List<BeerStyle> getAllStyles() {
        return service.getAllStyles();
    }
}

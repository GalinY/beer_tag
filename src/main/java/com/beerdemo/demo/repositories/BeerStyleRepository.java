package com.beerdemo.demo.repositories;

import com.beerdemo.demo.entities.BeerStyle;

import java.util.List;

public interface BeerStyleRepository {
    List<BeerStyle> getAllStyles();
}

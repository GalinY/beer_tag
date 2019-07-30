package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "breweries")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long brewery_id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id")
    private OriginCountry country;

    @JsonIgnore
    @OneToMany(mappedBy = "brewery")
    private List<Beer> beers;

    public Brewery() {
    }

    public Brewery(String name, OriginCountry country) {
        this.name = name;
        this.country = country;
        this.beers = new ArrayList<>();
    }

    public Brewery(OriginCountry country) {
        this.country=country;
    }

    public Brewery(String name) {
        this.name=name;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    public long getId() {
        return brewery_id;
    }

    public void setId(long brewery_id) {
        this.brewery_id = brewery_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OriginCountry getCountry() {
        return country;
    }

    public void setCountry(OriginCountry country) {
        this.country = country;
    }
}

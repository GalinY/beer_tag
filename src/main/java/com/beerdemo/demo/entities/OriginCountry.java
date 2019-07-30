package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "origin_countries")
public class OriginCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long country_id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Beer> beers;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    public OriginCountry(String name,Brewery brewery) {
        this.name = name;
//        this.beers = new ArrayList<>();
        this.brewery = brewery;

    }

    public OriginCountry(String name) {
        this.name = name;
    }

    public OriginCountry() {
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long id) {
        this.country_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}

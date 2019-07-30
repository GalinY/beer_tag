package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "styles")
@Entity
public class BeerStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long style_id;

    private String name;

   //
    // @JsonIgnore
   //
    // @OneToMany(mappedBy = "styles")
   //
    // private List<Beer> beerList;

    @Autowired
    public BeerStyle(String name) {
        this.name = name;
      //  this.beerList = new ArrayList<>();
    }

    public BeerStyle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   //public List<Beer> getBeerList() {
   //    return beerList;
   //}

   //public void setBeerList(List<Beer> beerList) {
   //this.beerList = beerList;
   //}

    public long getStyle_id() {
        return style_id;
    }

    public void setStyle_id(long id) {
        this.style_id = id;
    }
}

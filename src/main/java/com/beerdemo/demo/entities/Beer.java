package com.beerdemo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long beer_id;

    @Column(name = "beer_name")
    private String beer_name;

//    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

//    @JsonIgnore
//    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private OriginCountry country;

    @Column(name = "ABV")
    private double ABV;

    @Column(name = "description")
    private String description;

//    @JsonIgnore
//    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id")
    private BeerStyle style;

    @Column(name = "rating")
    private double rating;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tags_beers", joinColumns = {@JoinColumn(name = "beer_id")}, inverseJoinColumns =
            {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;

//    @OneToOne
//    @JoinColumn(name = "pic_id")
//    private

    public Beer() {

    }

    public Beer(String beer_name, double ABV, String description, double rating) {
        this.beer_name = beer_name;
        this.ABV = ABV;
        this.description = description;
        this.rating = rating;
        this.tags = new ArrayList<>();
    }

    public Beer(long beer_id, String beer_name, Brewery brewery, OriginCountry country, double ABV, String description,
                BeerStyle style,
                double rating) {
        this.beer_id = beer_id;
        this.beer_name = beer_name;
        this.brewery = brewery;
        this.country = country;
        this.ABV = ABV;
        this.description = description;
        this.style = style;
        this.rating = rating;
        this.tags = new ArrayList<>();
    }

    public Beer(String beer_name, double rating, double ABV, Brewery brewery, BeerStyle style,OriginCountry country) {

    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String name) {
        this.beer_name = name;
    }

    public long getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(long id) {
        this.beer_id = id;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public OriginCountry getCountry() {
        return country;
    }

    public void setCountry(OriginCountry origin) {
        this.country = origin;
    }

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BeerStyle getStyle() {
        return style;
    }

    public void setStyle(BeerStyle style) {
        this.style = style;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beer_id=" + beer_id +
                ", beer_name='" + beer_name + '\'' +
                ", brewery=" + brewery +
                ", country=" + country +
                ", ABV=" + ABV +
                ", description='" + description + '\'' +
                ", style=" + style +
                ", rating=" + rating +
                ", tags=" + tags +
                '}';
    }
}

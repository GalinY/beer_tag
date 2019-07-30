package com.beerdemo.demo.entities;


import javax.persistence.*;

@Entity
@Table(name = "user_beer_rating")
public class UserRate {

    @Id
    @Column(name = "users_beers_rating_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //   @Column(name = "user_id")
    @JoinColumn(name = "user_id")
    private int user_id;

    //   @Column(name = "beer_id")
    @JoinColumn(name = "beer_id")
    private int beer_id;

    @Column(name = "vote")
    private double vote;

    public UserRate() {

    }

    public UserRate(int user_id, int beer_id, double vote) {
        setUser_id(user_id);
        setBeer_id(beer_id);
        setVote(vote);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(int beer_id) {
        this.beer_id = beer_id;
    }
}

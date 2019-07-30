package com.beerdemo.demo.controllers;

import com.beerdemo.demo.entities.*;
import com.beerdemo.demo.exceptions.UsernameAlreadyExistException;
import com.beerdemo.demo.services.BeerService;
import com.beerdemo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/admin/")
public class AdminController {
    private BeerService beerService;
    private UserService userService;

    @Autowired
    public AdminController(BeerService beerService, UserService userService) {
        this.beerService = beerService;
        this.userService = userService;
    }

    //USERS
    @GetMapping("/users/{user_id}")
    public User getUserById(@PathVariable long user_id) {
        return userService.getUserById(user_id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String first_name) {
        if (first_name == null || first_name.isEmpty()) {
            return userService.getAllUsers();
        }
        return userService.getByName(first_name);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("/users/update/firstName/{user_id}/{firstName}")
    public User updateFirstName(@PathVariable long user_id, @PathVariable String firstName) {
        return userService.updateFirstName(user_id, firstName);
    }

    @PostMapping("/users/update/lastName/{user_id}/{lastName}")
    public User updateLastName(@PathVariable long user_id, @PathVariable String lastName) {
        return userService.updateLastName(user_id, lastName);
    }

    @PostMapping("/users/update/eMail/{user_id}/{eMail}")
    public User updateEmail(@PathVariable long user_id, @PathVariable String eMail) {
        return userService.updateEmail(user_id, eMail);
    }


    @PostMapping("/users/update/password/{user_id}/{password}")
    public User updatePassword(@PathVariable long user_id, @PathVariable String password) {
        return userService.updatePassword(user_id, password);
    }

    @PostMapping("/users/update/userName/{user_id}/{userName}")
    public User updateUserName(@PathVariable long user_id, @PathVariable String userName) {
        return userService.updateUserName(user_id, userName);
    }

    @PostMapping("/users/new")
    User create(@RequestBody User user) throws UsernameAlreadyExistException {
        HashSet<String> users = userService.getAllUsers().stream()
                                           .map(User::getUsername).collect(Collectors.toCollection(HashSet::new));
        if (users.contains(user.getUsername())) {
            throw new UsernameAlreadyExistException("This username already exist!");
        }
        userService.create(user);
        return user;
    }

    //BEERS

    @DeleteMapping("/beers/{beer_id}")
    public void deleteBeer(@PathVariable long beer_id) {
        beerService.delete(beer_id);
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers(@RequestParam(required = false) String search) {
        if (search == null || search.isEmpty()) {
            return beerService.getAllBeers();
        }
        return beerService.getByName(search);
    }

    @GetMapping("/beers/{beer_id}")
    public Beer getBeerByID(@PathVariable long beer_id) {
        return beerService.getBeerByID(beer_id);
    }

    @PostMapping("/beers/new")
    public Beer create(@RequestBody Beer beer) {
        try {
            beerService.create(beer);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        return beer;
    }

    @PostMapping("/beers/{beer_id}")
    public Beer updateBeer(@PathVariable long beer_id, @RequestBody Beer beer) {
        if (beer.getBeer_name() != null && !beer.getBeer_name().isEmpty()) {

            return beerService.updateName(beer_id, beer.getBeer_name());
        }

        return beerService.getBeerByID(beer_id);
    }

    @PostMapping("/beers/update/name/{beer_id}/{beer_name}")
    public Beer updateName(@PathVariable long beer_id, @PathVariable String beer_name) {
        return beerService.updateName(beer_id, beer_name);
    }

    @PostMapping("/beers/update/ABV/{beer_id}/{ABV}")
    public Beer updateABV(@PathVariable long beer_id, @PathVariable double ABV) {
        return beerService.updateABV(beer_id, ABV);
    }

    @PostMapping("/beers/update/country/{beer_id}/country")
    public Beer updateCountry(@PathVariable long beer_id, @RequestBody OriginCountry country) {
        return beerService.updateCountry(beer_id, country);
    }

    @PostMapping("/beers/update/description/{beer_id}/{description}")
    public Beer updateDescription(@PathVariable long beer_id, @PathVariable String description) {
        return beerService.updateDescription(beer_id, description);
    }

    @PostMapping("/beers/update/brewery/{beer_id}/brewery")
    public Beer updateBrewery(@PathVariable long beer_id, @RequestBody Brewery brewery) {
        return beerService.updateBrewery(beer_id, brewery);
    }

    @PostMapping("/beers/update/style/{beer_id}/beerStyle")
    public Beer updateStyle(@PathVariable long beer_id, @RequestBody BeerStyle beerStyle) {
        return beerService.updateStyle(beer_id, beerStyle);
    }


}

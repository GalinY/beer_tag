package com.beerdemo.demo.controllers;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.services.BeerService;
import com.beerdemo.demo.utils.JwtParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    //    private UserService service;
    private BeerService beerService;
    private JwtParser jwtParser;


    @Autowired
    public UserController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping("/beers/{beer_id}")
    public Beer getBeerByID(@PathVariable long beer_id) {
        return beerService.getBeerByID(beer_id);
    }

    @GetMapping("/beers/filter/country")
    List<Beer> filterByCountry(@RequestParam String country) {
        return beerService.filterByCountry(country);
    }

    @PostMapping("/beers/{beer_id}/rating")
    public Beer updateRating(@PathVariable int beer_id, @RequestBody double rating) {
        Beer beer = getBeerByID(beer_id);
        if (beer == null) {
//             HttpStatus.NOT_FOUND;
        }
        return beerService.updateRating(rating, beer_id);
    }

    @GetMapping("/beers/filter/tag")
    public List<Beer> filterByTags(@RequestParam String tag) {
        return beerService.filterByTag(tag);
    }

    @GetMapping("/beers/filter/style")
    List<Beer> filterByParam(@RequestParam String style) {
        return beerService.filterByStyle(style);
    }

    @GetMapping("/beers/orderBy")
    List<Beer> sort(@RequestParam String orderBy) {

        try {
            if (orderBy.equals("ABV")) return beerService.sortByABV();
            if (orderBy.equals("rating")) return beerService.sortByRating();
            else return beerService.sortAlphabetical();
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }


// Moved to Admin Controller
//    @GetMapping
//    public List<User> getAllUsers(@RequestParam(required = false) String first_name) {
//        if (first_name == null || first_name.isEmpty()) {
//            return service.getAllUsers();
//        }
//        return service.getByName(first_name);
//    }
//
//    public void delete(long id) {
//        service.delete(id);
//    }

    /*@PostMapping("/update/user/{user_id}/{firstName}/{lastName}/{eMail}/{password}/{rights_id}/{userName}")
    void updateUser(@PathVariable long user_id,@PathVariable String firstName,@PathVariable(required = false) String
    lastName,@PathVariable(required = false) String eMail,@PathVariable(required = false) String password,
    @PathVariable(required = false) int rights_id,@PathVariable(required = false) String userName){
        service.updateUser(user_id,firstName,lastName,eMail,password,rights_id,userName);
    }*/

//    @PostMapping("/update/firstName/{user_id}/{firstName}")
//    public void updateFirstName(@PathVariable long user_id, @PathVariable String firstName) {
//        service.updateFirstName(user_id, firstName);
//    }
//
//    @PostMapping("/update/lastName/{user_id}/{lastName}")
//    public void updateLastName(@PathVariable long user_id, @PathVariable String lastName) {
//        service.updateLastName(user_id, lastName);
//    }
//
//    @PostMapping("/update/eMail/{user_id}/{eMail}")
//    public void updateEmail(@PathVariable long user_id, @PathVariable String eMail) {
//        service.updateEmail(user_id, eMail);
//    }
//
//
//    @PostMapping("/update/password/{user_id}/{password}")
//    public void updatePassword(@PathVariable long user_id, @PathVariable String password) {
//        service.updatePassword(user_id, password);
//    }
//
//    @PostMapping("/update/right/{user_id}/{rights_id}")
//    public void updateRight(@PathVariable long user_id, @PathVariable long rights_id) {
//        service.updateRole(user_id, rights_id);
//    }
//
//    @PostMapping("/update/userName/{user_id}/{userName}")
//    public void updateUserName(@PathVariable long user_id, @PathVariable String userName) {
//        service.updateUserName(user_id, userName);
//    }
//
//    @PostMapping("/new")
//    User create(@RequestBody User user) {
//        service.create(user);
//        return user;
//    }

//    @GetMapping("/login")
//    public String getLogin(@RequestParam(required = true) String error, Model model) {
////    TODO FIND OUT WHICH IS THE FILE THAT IS RESPONSIBLE FOR SENDING THE RESPONSE FROM THE UI VUE
//        return "Login.vue"; //view
//    }

//    @PostMapping("/register")
//    @PreAuthorize("WebSecurity")
//    public String registerUser(@ModelAttribute ) {
//        return null;
//    }
}

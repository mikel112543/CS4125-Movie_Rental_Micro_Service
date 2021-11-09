package com.example.movierental.controllers;

import com.example.movierental.model.Rental;
import com.example.movierental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    UserService userService;

    @Autowired
    PriceService priceService;


    /**
     * @param customerId - Customer ID wanting the rent the movie
     * @param movieId    - Movie ID to be rented
     * @return User.html
     */
    @PostMapping(value = "/customerId/{CUSTOMER_ID}/movieIdRent/{MOVIE_ID}")
    public String rentMovieView(@PathVariable("CUSTOMER_ID") final int customerId,
                                @PathVariable("MOVIE_ID") final int movieId) {
        //Information passed over URL to be user in function
        rentalService.rentMovie(customerId, movieId);
        return "User";

    }

    /**
     * @param customerId customer ID for the rentals
     * @return User.html
     */
    @GetMapping(value = "/customerId/{CUSTOMER_ID}/rentals")
    public String showRentalsView(@PathVariable("CUSTOMER_ID") final int customerId, Model model) {
        List<Rental> userRentals = userService.getUserRentals(customerId);
        model.addAttribute("userRentals", userRentals); //Attach List of rentals to model to be used in Thymeleaf
        return "User";
    }

    /**
     * @param customerId the ID of the customer who owns the rental
     * @param movieId    Unique identifier for the movie
     * @return User.html
     */
    @GetMapping(value = "/customerId/{CUSTOMER_ID}/rentals/{MOVIE_ID}")
    public String showRentalView(@PathVariable("CUSTOMER_ID") final int customerId,
                                 @PathVariable("MOVIE_ID") final int movieId,
                                 Model model) {

        Rental rental = userService.getRental(customerId, movieId);
        model.addAttribute("rental", rental); //Attach rental to model to be used in Thymeleaf

        return "User";
    }

    /**
     * @param customerId - the ID of the customer who owns the rental
     * @param movieId    - Unique identifier for the movie
     * @return User.html
     */
    @DeleteMapping(value = "/customerId/{CUSTOMER_ID}/rentals/rentalRemoveId/{MOVIE_ID}")
    public String removeRentalView(@PathVariable("CUSTOMER_ID") final int customerId,
                                   @PathVariable("MOVIE_ID") final int movieId) {
        rentalService.removeRental(customerId, movieId);
        return "User";

    }
}

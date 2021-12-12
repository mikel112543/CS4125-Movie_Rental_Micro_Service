package com.example.movierental.controller;
import com.example.movierental.model.User;
import com.example.movierental.service.UserRepoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Author - Michael Danaher
 */
@Controller //CRUD
public class CustomerController {

    UserRepoServiceImpl userService;

    @Autowired
    public CustomerController(UserRepoServiceImpl userService) {
        this.userService = userService;
    }

    /**
     *
     * @param customerId find by customer ID
     * @return JSON Object Customer
     */
    @GetMapping(value = "/customerId/{CUSTOMER_ID}")
    @ResponseBody
    public User getUser(@PathVariable("CUSTOMER_ID") final int customerId) {
        return userService.findByID(customerId);
    }
}

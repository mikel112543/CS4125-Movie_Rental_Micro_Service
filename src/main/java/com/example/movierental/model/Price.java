package com.example.movierental.model;

import com.example.movierental.service.UserRepoServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Price Class - Pricing Structure for the Movies
 * Author - Jack Murphy - 18254268
 */
public abstract class Price {

    @JsonIgnore
    private double price; //price of the movie per day
    @JsonIgnore
    private int loyaltyPoints; //loyalty points per day of rental of the movie

    /**
     * Getter for price
     * @return int price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for Loyalty Points
     * @return int loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Setter for Loyalty Points
     * @param loyaltyPoints
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * Returns the Charge for renting a movie with no discount
     * @return double charge
     */
    public double getCharge(){
        return getPrice();
    }


    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

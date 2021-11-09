package com.example.movierental.model;

import java.util.ArrayList;

public class Customer extends User{

    private int loyaltyPoints;
    private int tier;
    private ArrayList<Rental> userMovies = new ArrayList<>();

    public Customer(){
        //empty constructor
    }

    //constructor for new Customer
    public Customer(int userID, String username, String password, Boolean banned) {
        super(userID, username, password, banned);
    }

    //Constructor for existing Customer
    public Customer(int userID, String username, String password, Boolean banned, int loyaltyPoints, int tier, ArrayList<Rental> userMovies) {
        super(userID, username, password, banned);
        this.loyaltyPoints = loyaltyPoints;
        this.tier = tier;
        this.userMovies = userMovies;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public ArrayList<Rental> getUserMovies() {
        return userMovies;
    }

    public void setUserMovies(ArrayList<Rental> userMovies) {
        this.userMovies = userMovies;
    }

    @Override
    public String toString() {
        return super.toString() + "Customer{" +
                "loyaltyPoints=" + loyaltyPoints +
                ", tier=" + tier +
                ", userMovies=" + userMovies +
                '}';
    }
}

package com.example.movierental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * User Class
 * Author - Jack Murphy - 18254268
 */
public class User {

    @JsonIgnore
    private int userID;

    @JsonProperty("Username")
    private String username;

    @JsonIgnore
    private String password;

    @JsonProperty("Banned")
    private boolean banned;

    @JsonProperty("Loyalty Points")
    private int loyaltyPoints;

    //Redundant?
    @JsonProperty("Tier")
    private int tier;

    @JsonIgnore
    private List<Rental> rentedMovies;

    @JsonProperty("Is Admin")
    private boolean isAdmin;


    //Empty Constructor for User
    public User() {
    }

    /**
     * Full Parameterised Constructor for User
     * @param userID
     * @param username
     * @param password
     * @param banned
     * @param loyaltyPoints
     * @param tier
     * @param rentedMovies
     * @param isAdmin
     */
    public User(int userID, String username, String password, boolean banned, int loyaltyPoints, int tier, List<Rental> rentedMovies, boolean isAdmin) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.banned = banned;
        this.loyaltyPoints = loyaltyPoints;
        this.tier = tier;
        this.rentedMovies = rentedMovies;
        this.isAdmin = isAdmin;
    }

    /**
     * Parameterised Constructor with two parameters
     * @param userID
     * @param username
     */
    public User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    /**
     * Getter for userID
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Setter for userID
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Getter for userName
     * @return String userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for userName
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for Password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for Password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns whether the User is banned or not as a boolean
     * @return boolean banned
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Setter for Users banned value
     * @param banned
     */
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    /**
     * Gets the loyalty points a User has earned
     * @return int loyaltyPoints
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Setter for loyalty points
     * @param loyaltyPoints
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    //Redundant?
    public int getTier() {
        return tier;
    }

    //Redundant?
    public void setTier(int tier) {
        this.tier = tier;
    }

    /**
     * Returns list of Movies currently rented by User
     * @return
     */
    public List<Rental> getRentedMovies() {
        return rentedMovies;
    }

    /**
     * Setter for movies rented by a customer
     * @param rentedMovies
     */
    public void setRentedMovies(List<Rental> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    /**
     * Returns whether a User is an Admin or not
     * @return boolean isAdmin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Setter for admin status
     * @param admin boolean
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * Returns userId and username as a string
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                '}';
    }
}
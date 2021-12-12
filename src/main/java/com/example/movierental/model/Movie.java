package com.example.movierental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.Duration;

/**
 * Movie Class
 * Author - Jack Murphy - 18254268
 */
@JsonRootName("Movie Details")
public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Description")
    private String description;

    //changed to duration
    @JsonProperty("Length")
    private String length;

    @JsonIgnore
    private int movieId;

    @JsonProperty("Rating")
    private int movieRating;

    @JsonIgnore
    private Price price;

    @JsonProperty("Price")
    private String priceStr;

    public Movie() {
        //empty constructor
    }

    /**
     * Parameterised Constructor
     * @param movieId
     * @param title
     * @param genre
     * @param description
     * @param length
     * @param priceCode
     * @param movieRating
     */
    public Movie(int movieId, String title, String genre, String description, String length, int priceCode, int movieRating) {

        PriceFactory p = new PriceFactory();
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.length = length;
        this.price = p.getPrice(priceCode);
        this.movieRating = movieRating;
        getPriceStr();
    }

    /**
     * Getter for movieId
     * @return
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Calculates the charge based on the type of movie (type of price object)
     * Calls getCharge in Price Class
     * @return double charge for renting movie
     */
    public double getCharge(){
        return price.getCharge();
    }

    /**
     * Calculates the charge based on the type of movie and discount given as int meaning percentage
     * @param discount
     * @return double charge for renting movie
     */
    //calls prices get charge method
    public double getCharge(int discount){
        return price.getCharge(discount);
    }

    //calls prices get loyalt points earned method
    //public int getLoyaltyPointsEarned(int numberOfDays){
    //    return price.getLoyaltyPointsEarned(numberOfDays);
    //}

    /**
     * Gets loyalty points, value is set in respective Price Sub Class
     * @return int loyaltyPoints
     */
    public int getLoyaltyPoints(){
        return price.getLoyaltyPoints();
    }

    /**
     * Getter for Movie Title
     * @return String Movie Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for Movie Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for Movie Genre
     * @return String Genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter for Movie Genre
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Getter for Movie Description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for Movie Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for Movie Length (hours)
     * @return String Movie Length
     */
    public String getLength() {
        return length;
    }

    /**
     * Setter for Movie Length
     * @param length
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * Returns a Price Object.  Different for charge of the movie or price for renting.  Its a pricing structure
     * @return Price Price
     */
    public Price getPrice(){
        return price;
    }

    /**
     * To be able to set the Pricing structure of a movie
     * 0 = New Release
     * 1 = Standard Release
     * 2 = Childrens Release
     * @param priceCode
     */
    public void setPrice(int priceCode) {
        PriceFactory p = new PriceFactory();
        this.price = p.getPrice(priceCode);
    }

    /**
     * Setter for MovieID
     * @param movieId
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Getter for Movie Rating
     * @return int Movie Rating
     */
    public int getMovieRating() {
        return movieRating;
    }

    /**
     * Setter for Movie Rating
     * @param movieRating
     */
    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    /**
     * Returns price (with no discount) as a String, with a € sign
     * @return String price
     */
    public String getPriceStr() {
        priceStr = "€"+ price.getPrice();
        return priceStr;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", length='" + length + '\'' +
                ", movieId=" + movieId +
                ", movieRating=" + movieRating +
                ", price=" + price +
                '}';
    }
}

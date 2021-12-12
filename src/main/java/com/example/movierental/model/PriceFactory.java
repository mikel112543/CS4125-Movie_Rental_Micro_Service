package com.example.movierental.model;

/**
 * PriceFactoryClass
 * Implementation of the Factory Method, Used in the Movie Constructor
 * Author - Jack Murphy - 18254268
 */
public class PriceFactory {

    /**
     * priceCode dictates which Price subclass is returned
     * 0 = New Release
     * 1 = Standard Release
     * 2 = Childrens Release
     * @param priceCode
     * @return Subclass of Price
     */
    public Price getPrice(int priceCode){

        if(priceCode == 0){
            return new newReleasePrice();
        } else if(priceCode == 1){
            return new standardReleasePrice();
        }else if(priceCode == 2){
            return new childrensReleasePrice();
        }else{
            System.out.println("Enter error checking here");
        }
        return null;
    }
}

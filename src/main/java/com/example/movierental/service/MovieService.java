package com.example.movierental.service;


import com.example.movierental.model.Movie;

import java.util.ArrayList;

public interface MovieService {
    ArrayList<Movie> listAllMovies();

    Movie findByMovieID(int movieID);

    ArrayList<Movie> findByName(String searchbar);

    void initializeListOfMovies();
}
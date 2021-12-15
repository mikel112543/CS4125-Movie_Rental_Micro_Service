package com.example.movierental.model;

import com.example.movierental.model.Movie.MovieBuilder;
import com.example.movierental.service.UserRepoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;
/**
 * MovieTest Class
 * Author - Jack Murphy 18254268
 */

@Repository("users")
@WithMockUser(username = "john")
class MovieTest {

    @Autowired
    UserRepoServiceImpl userRepo;

    User testUser;

    private Movie testMovie1, testMovie2;
    private MovieBuilder testMovieBuilder;

    @BeforeEach
    void setUp() {
        testMovieBuilder = new MovieBuilder("Test Movie One","Genre NewPrice","Described as \"Good for Testing\"","1.1",11111,"Test1.jpg");
        testMovieBuilder.setPrice(0,userRepo);
        testMovie1 = testMovieBuilder.build();

        testMovieBuilder = new MovieBuilder("Test Movie Two","Genre ChildrensPrice","Described as \"Grand for Testing\"","1.3",333333,"Test2.jpg");
        testMovieBuilder.setPrice(2,userRepo);
        testMovie2 = testMovieBuilder.build();
    }

    @AfterEach
    void tearDown() {
        testMovie1 = null;
        testMovie2 = null;
        testMovieBuilder = null;
    }

    @Test
    void testTierOne(){

    }

    @Test
    @DisplayName("Testing Builder with Getters")
    void testBuilder(){
        assertEquals("Test Movie One",testMovie1.getTitle());
        assertEquals("Genre NewPrice",testMovie1.getGenre());
        assertEquals("Described as \"Good for Testing\"",testMovie1.getDescription());
        assertEquals("1.1",testMovie1.getLength());
        assertEquals(11111,testMovie1.getMovieId());
        assertEquals("Test1.jpg",testMovie1.getMovieCoverUrl());
        assertTrue(testMovie1.getPrice() instanceof NewPrice);

        assertEquals("Test Movie Two",testMovie2.getTitle());
        assertEquals("Genre ChildrensPrice",testMovie2.getGenre());
        assertEquals("Described as \"Grand for Testing\"",testMovie2.getDescription());
        assertEquals("1.3",testMovie2.getLength());
        assertEquals(333333,testMovie2.getMovieId());
        assertEquals("Test2.jpg",testMovie2.getMovieCoverUrl());
        assertTrue(testMovie2.getPrice() instanceof ChildrensPrice);

    }


}
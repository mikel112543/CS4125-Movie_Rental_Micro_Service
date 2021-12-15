package com.example.movierental.model;

import com.example.movierental.exception.ServiceException;
import com.example.movierental.service.UserRepoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PriceFactoryTest Class
 * Author - Jack Murphy 18254268
 */

@WithMockUser(username = "john")
class PriceFactoryTest {

    @Autowired
    UserRepoServiceImpl userRepo;

    private Price p1, p2, p3, p4;
    private PriceFactory p;
    /**
     * priceCodes
     * 0 = New Release
     * 1 = Standard Release
     * 2 = Childrens Release
     */
    @BeforeEach
    void setUp() {
        p = new PriceFactory();
        p1 = p.getPrice(0, userRepo);
        p2 = p.getPrice(1, userRepo);
        p3 = p.getPrice(2, userRepo);
    }

    @AfterEach
    void tearDown() {
        p = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Test
    @DisplayName("Testing Price Factory Returns the Correct Price Class Based on Price Code")
    void testGetPrice() {
        assertTrue(p1 instanceof NewPrice);
        assertTrue(p2 instanceof StandardPrice);
        assertTrue(p3 instanceof ChildrensPrice);
    }

    @Test
    @DisplayName("Should Return a ServiceError if Incorrect PriceCode Entered")
    void testWrongPriceCode(){
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            p4 = p.getPrice(5,userRepo);
        });
        assertEquals("2013",exception.getServiceError().getErrorCode());
    }
}
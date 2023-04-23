package com.UserService;

import com.UserService.Entity.Ratings;
import com.UserService.ExternalService.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired
//    private RatingService ratingService;
//
//    @Test
//    void createRating() {
//        Ratings ratings = Ratings.builder().rating(10).userId(" ").hotelId(" ").feedback("Good to go").build();
//        ResponseEntity<Ratings> ratingsResponseEntity = ratingService.createRating(ratings);
//        System.out.println("new reating created");
//    }
}

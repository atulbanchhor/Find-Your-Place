package com.UserService.ExternalService;

import com.UserService.Entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("Rating-Service")
@Service
public interface RatingService {

    //get

    //post
    @PostMapping("/ratings")
    public ResponseEntity<Ratings> createRating(Ratings values);


    // put
    @PutMapping("/ratings?{ratingsId}")
    public ResponseEntity<Ratings> updateRating(@PathVariable String ratingID, Ratings ratings );


    //Delete
    @DeleteMapping
    public void deleteRating(@PathVariable String ratingId);
}

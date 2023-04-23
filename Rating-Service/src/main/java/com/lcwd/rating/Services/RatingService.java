package com.lcwd.rating.Services;

import com.lcwd.rating.Entity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create (Rating rating);

    //get all rating
    List<Rating> getRatings();

    // get all by userid
    List<Rating> getRatingByUserId(String userId);

    // get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
 }

package com.UserService.Entity;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ratings extends ArrayList<Ratings> {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
    private Hotel hotel;
}
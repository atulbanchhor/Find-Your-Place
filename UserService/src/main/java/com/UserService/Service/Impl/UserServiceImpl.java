package com.UserService.Service.Impl;

import com.UserService.Entity.Hotel;
import com.UserService.Entity.Ratings;
import com.UserService.Entity.User;
import com.UserService.Exception.ResourceNotFoundException;
import com.UserService.ExternalService.HotelServices;
import com.UserService.Repository.UserRepository;
import com.UserService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    //    By default, the @Autowired annotation implies that the dependency is required.
//    This means an exception will be thrown when a dependency is not resolved.
//    You can override that default behavior using the (required=false) option with @Autowired .
    @Autowired(required = false)
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override        // create
    public User saveUser(User user) {

        //generate unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override            // get all user
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override       // get single user of given userID
    public User getUser(String userID) {
        User user = userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException(userID + " User  id is not in the database"));

//        ----------------------------with restTemplate-----------------------------

        // fetch rating of the above user from RATING SERVICE
        //  http://localhost:8081/ratings/users/----userid-----
        Ratings[] ratingsOfUser = restTemplate.getForObject(" http://Rating-Service/ratings/users/" + user.getUserId(),Ratings[].class);
        logger.info("{}", ratingsOfUser);

        List<Ratings> rating=Arrays.stream(ratingsOfUser).toList();

//        ---------------------------- end with  restTemplate-----------------------------

        List<Ratings> ratingsList = rating.stream().map(ratings -> {

            //api call to hotel service to get the hotel
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http//:HotelService/hotels/"+ratings.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
//            logger.info("response status code: {} ",forEntity.getStatusCode());

//            ---------------------------with feign client-------------
            Hotel hotel = hotelServices.getHotel(ratings.getHotelId());
//            ---------------------------end with feign client-------------


            // set the hotel to rating
            ratings.setHotel(hotel);
            // return the rating
            return ratings;
        }).collect(Collectors.toList());
        user.setRatings((Ratings) ratingsList);
        return user;
    }

    //todo:update from the server
    //todo:delete from the server
}
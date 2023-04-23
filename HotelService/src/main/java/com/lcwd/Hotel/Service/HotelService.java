package com.lcwd.Hotel.Service;

import com.lcwd.Hotel.Entity.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    // ger single
    Hotel get(String id);
}

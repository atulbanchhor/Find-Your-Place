package com.lcwd.Hotel.Service.Implement;

import com.lcwd.Hotel.Entity.Hotel;
import com.lcwd.Hotel.Exception.ResourceNotFoundException;
import com.lcwd.Hotel.Repository.HotelRepository;
import com.lcwd.Hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override               //create
    public Hotel create(Hotel hotel) {
       String hotelId = UUID.randomUUID().toString();       // this is for generate random number
       hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override           // GET ALL DATA
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override          // GET BY ID
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id is not found !"));
    }
}

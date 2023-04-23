package com.UserService.Service;

import com.UserService.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //    user operation

    User saveUser(User user);            // create
    List<User> getAllUser();            // get all user
    User getUser(String userID);       // get single user of given userID

    //TODO: delete
    //TODO: update
}

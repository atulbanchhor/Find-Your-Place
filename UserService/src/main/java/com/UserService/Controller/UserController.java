package com.UserService.Controller;

import com.UserService.Entity.User;
import com.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    // ResponseEntity is commonly used in REST ful web services to send data back to the client.
    // @ResponseBody binds the method return value to the response body . ter tells the spring boot framework to serialize a return an object into  jason & xml format
    // @RequestBody annotation you will get your values mapped with the model you created in your system for handling any specific call.

    //----create or save ----//
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //For example, consider a RESTful web service that provides information about books.
    // A request to the URL "/books/123" might be used to retrieve information about the book with an ID of 123.
    // In this case, "123" is the path variable.

    //----single user get----//
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //----all user get----//
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);

    }
}

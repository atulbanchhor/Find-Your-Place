package com.UserService.Repository;

import com.UserService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {

    // if we want to implement any custom method or query


}

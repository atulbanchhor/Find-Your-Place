package com.UserService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "E-mail")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    // other user properties that we want
    private List<Ratings> ratings = new ArrayList<>();
}
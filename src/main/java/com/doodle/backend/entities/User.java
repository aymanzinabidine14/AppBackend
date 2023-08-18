package com.doodle.backend.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.doodle.backend.entities.Sandage;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Sandage> sandages_c;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Sandage> sandages_p = new ArrayList<>();



    @ManyToMany (mappedBy = "userList",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Option> options=new ArrayList<>();

    public User(Long idUser, String username, String email, String password) {
        IdUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
    }




}


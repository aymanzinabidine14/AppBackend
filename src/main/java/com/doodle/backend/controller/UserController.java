package com.doodle.backend.controller;

import com.doodle.backend.DTO.LoginDTO;
import com.doodle.backend.DTO.userDTO;
import com.doodle.backend.Response.LoginResponse;
import com.doodle.backend.entities.User;
import com.doodle.backend.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;


    @GetMapping("/user{id}")
    public User getUser(@PathVariable Long id){return userServiceImp.getUser(id);}

    @PostMapping("/saveUser")
    public String addUser(@RequestBody userDTO userdto)
    {
        return userServiceImp.addUser(userdto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userServiceImp.LoginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }









}

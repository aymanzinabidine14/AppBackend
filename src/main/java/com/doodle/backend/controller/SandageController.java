package com.doodle.backend.controller;


import com.doodle.backend.entities.Option;
import com.doodle.backend.entities.Sandage;
import com.doodle.backend.entities.User;
import com.doodle.backend.services.SandageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SandageController {


    @Autowired
    SandageServiceImp sandageServiceImp;


    @GetMapping("/sandages")
     List<Sandage> getAllSandage(){
        return sandageServiceImp.getSandages();
    }

    @PostMapping ("/saveSandage")
     Sandage saveSandage(@RequestBody Sandage sandage){
        return sandageServiceImp.saveSandage(sandage);
    }

    @GetMapping ("/sandage/{id}")
    Sandage getSandage(@PathVariable Long id){
        return sandageServiceImp.getSandage(id);
    }


    @GetMapping ("/UsersBySandage/{id}")

    List <User> getUsersBySandage(@PathVariable Long id){
        Sandage sandage=sandageServiceImp.getSandage(id);

        List <User> users=sandage.getUsers();

        return users;
    }

    @GetMapping ("/OptionsBySandage/{id}")

    List <Option> getOptionsBySandage(@PathVariable Long id){
        Sandage sandage=sandageServiceImp.getSandage(id);
        List <Option> Options=sandage.getOptions();
        return Options;
    }





}

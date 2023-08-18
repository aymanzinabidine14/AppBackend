package com.doodle.backend.controller;


import com.doodle.backend.entities.Option;
import com.doodle.backend.entities.Sandage;
import com.doodle.backend.services.OptionServiceImp;
import com.doodle.backend.services.SandageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OptionController {


    @Autowired
    OptionServiceImp optionServiceImp;


    @GetMapping("/options")
    public List<Option> getAllOptions() {
        return optionServiceImp.getOptions();
    }

    @PostMapping("/saveOption")
    Option saveOption(@RequestBody Option option) {

        return optionServiceImp.saveOption(option);
    }
}



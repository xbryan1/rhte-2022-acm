package com.demos.springapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParrotController {

    @RequestMapping("/id/{id}")
    public String parrot(@PathVariable String id){
        return "Your Id is : " + id;
    }
}

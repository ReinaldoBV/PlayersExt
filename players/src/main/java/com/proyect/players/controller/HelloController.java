package com.proyect.players.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String holaMundo (){
        return "Hola mundo, esto es Spring";
    }
    
}

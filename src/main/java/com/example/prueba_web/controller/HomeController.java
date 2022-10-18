package com.example.prueba_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        //return "redirect:/api/index";
        //return "redirect:htpp://eduv.tecazuay.edu.ec/";
        //return "https://eduv.tecazuay.edu.ec/";
    return "forward:/api/index";
    }
}

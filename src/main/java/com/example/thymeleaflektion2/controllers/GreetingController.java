package com.example.thymeleaflektion2.controllers;

//import ch.qos.logback.core.model.Model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {
    List<String> test = new ArrayList<>();
    @GetMapping(path="/start")
    public String formStart(){
        return "form";   //htm-dokumentet med ett formulär
    }

    @PostMapping(path="/thanks")
    public String thanks(@RequestParam(name="fname") String fname, @RequestParam(name="lname") String lname, Model model){
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);

        test.add(fname+ " " + lname);

        return "greeting";
    }

}

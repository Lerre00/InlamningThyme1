package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Buy;
import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.BuyRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyControllerThyme {
    private BuyRepository buyRepository;

    public BuyControllerThyme(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @RequestMapping("/showBuys")
    public String getAll(Model model){

        Iterable<Buy> b = buyRepository.findAll();
        model.addAttribute("allBuys", b);
        model.addAttribute("name", "Buyname");
        model.addAttribute("buyTitle", "All Buys");
        return "showBuys";

    }

}

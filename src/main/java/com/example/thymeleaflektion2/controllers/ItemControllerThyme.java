package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemControllerThyme {
    private ItemRepository itemRepository;

    public ItemControllerThyme(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping("/showItems")
    public String getAll(Model model){

        Iterable<Item> i = itemRepository.findAll();
        model.addAttribute("allItems", i);
        model.addAttribute("name", "Itemname");
        model.addAttribute("itemTitle", "All Items");
        return "showItems";

    }

    @RequestMapping("/showOneItem")
    public String getItem(Model model){

        Item i = itemRepository.findById(1L).get();
        model.addAttribute("oneItem", i);
        model.addAttribute("name", "Itemname");
        model.addAttribute("pris", "Itempris");
        model.addAttribute("itemTitle", "All Items");
        return "showOneItem";

    }

}
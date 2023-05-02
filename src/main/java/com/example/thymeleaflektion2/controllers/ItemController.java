package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping("items")
    public List<Item> getAllItems(){return itemRepository.findAll();}

    @RequestMapping("items/{id}")
    public Item getItems(@PathVariable long id){


        return itemRepository.findById(id).get();

    }

    @PostMapping("items")
    public String addItemtoRepo(@RequestBody Item i){
        itemRepository.save(i);
        return "Varan " + i.getName() + " har lagts till";
    }

}
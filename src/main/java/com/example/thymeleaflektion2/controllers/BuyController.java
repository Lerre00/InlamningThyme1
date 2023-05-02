package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Buy;
import com.example.thymeleaflektion2.models.Customer;
import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.BuyRepository;
import com.example.thymeleaflektion2.repositories.CustomerRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
public class BuyController {

    private final BuyRepository buyRepo;
    private final CustomerRepository customerRepo;
    private final ItemRepository itemRepo;


    BuyController(BuyRepository buyRepo, CustomerRepository customerRepo, ItemRepository itemRepo) {
        this.buyRepo = buyRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }

    @RequestMapping("orders")
    public List<Buy> getAllOrders() {
        return buyRepo.findAll();
    }

    @RequestMapping("orders/{id}")
    public List<Buy> getCustomerOrder(@PathVariable Long id) {
        Customer customer = customerRepo.findById(id).get();
        System.out.println(customer);
        List<Buy> buyList = buyRepo.findByCustomer(customer);


        return buyList;
    }

    @RequestMapping("items/buy")
    public String addItemtoRepo(@RequestParam Long cId, @RequestParam Long iId){
        Customer customer = customerRepo.findById(cId).get();
        Item item = itemRepo.findById(iId).get();
        List<Item> mutableList = new ArrayList<>();
        mutableList.add(item);

        buyRepo.save(
                new Buy(
                        LocalDate.now(),
                        customer,
                        mutableList
                )
        );

        return customer.getName() + " har köpt: " + item.getName();
    }

}


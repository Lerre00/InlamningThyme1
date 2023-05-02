package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Customer;
import com.example.thymeleaflektion2.repositories.BuyRepository;
import com.example.thymeleaflektion2.repositories.CustomerRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final BuyRepository buyRepository;
    private final ItemRepository itemRepository;

    public CustomerController(CustomerRepository customerRepository, BuyRepository buyRepository, ItemRepository itemRepository) {
        this.customerRepository = customerRepository;
        this.buyRepository = buyRepository;
        this.itemRepository = itemRepository;
    }
    @RequestMapping("/customers")
    public List<Customer> getAllCostumers(){
        return customerRepository.findAll();
    }
    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable ("id") Long id){
        return customerRepository.findById(id).get();
    }

    /*@PostMapping("/customers")
    public String addCostumer(@RequestParam String name, String ssn){
        Customer c = new Customer(name, ssn);
        customerRepository.save(c);
        return "Customer "+name+ " saved";
    }*/

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer c){
        customerRepository.save(c);
        return "Customer "+c.getName()+" saved";
    }
}

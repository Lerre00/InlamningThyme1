package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Customer;
import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.CustomerRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerControllerThyme {
    private CustomerRepository customerRepository;

    public CustomerControllerThyme(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/showCustomers")
    public String getAll(Model model){

        Iterable<Customer> c = customerRepository.findAll();
        model.addAttribute("allCustomers", c);
        model.addAttribute("name", "Customername");
        model.addAttribute("customerTitle", "All Customers");
        return "showCustomers";

    }

}

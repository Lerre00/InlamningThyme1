package com.example.thymeleaflektion2.repositories;

import com.example.thymeleaflektion2.models.Buy;
import com.example.thymeleaflektion2.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Long> {

    List<Buy> findByCustomer(Customer customer);

}

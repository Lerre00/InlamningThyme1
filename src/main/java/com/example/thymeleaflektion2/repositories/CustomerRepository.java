package com.example.thymeleaflektion2.repositories;

import com.example.thymeleaflektion2.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

package com.example.thymeleaflektion2.repositories;

import com.example.thymeleaflektion2.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

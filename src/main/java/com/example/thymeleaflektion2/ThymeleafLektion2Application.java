package com.example.thymeleaflektion2;

import com.example.thymeleaflektion2.models.Buy;
import com.example.thymeleaflektion2.models.Customer;
import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.BuyRepository;
import com.example.thymeleaflektion2.repositories.CustomerRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ThymeleafLektion2Application {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafLektion2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepo, ItemRepository itemRepo, BuyRepository buyRepo) {
		return (args) -> {

			LocalDate date = LocalDate.of(2020, 10, 5);

			Customer c1 = new Customer("Kalle", "435255");
			Customer c2 = new Customer("Leroy", "000918");
			Customer c3 = new Customer("Anna", "931124");

			customerRepo.save(c1);
			customerRepo.save(c2);
			customerRepo.save(c3);

			Item item1 = new Item("football", 59);
			Item item2 = new Item("basketball", 49);
			Item item3 = new Item("frisbee", 39);

			List<Item> itemList1 = new ArrayList<>();
			List<Item> itemList2 = new ArrayList<>();
			List<Item> itemList3 = new ArrayList<>();

			itemList1.add(item1);
			itemList2.add(item2);
			itemList3.add(item3);

			itemRepo.save(item1);
			itemRepo.save(item2);
			itemRepo.save(item3);

			Buy buy1 = new Buy(date, c1, itemList1);
			Buy buy4 = new Buy(date, c1, itemList2);
			Buy buy5 = new Buy(date, c1, itemList3);
			Buy buy2 = new Buy(date, c2, itemList2);
			Buy buy3 = new Buy(date, c3, itemList3);

			buyRepo.save(buy1);
			buyRepo.save(buy4);
			buyRepo.save(buy5);
			buyRepo.save(buy2);
			buyRepo.save(buy3);

		};
	}
}

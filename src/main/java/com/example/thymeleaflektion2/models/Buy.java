package com.example.thymeleaflektion2.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Buy {
    @Id
    @GeneratedValue
    protected long id;
    protected LocalDate date;

    public Buy(LocalDate date) {
        this.date = date;
    }
    @ManyToOne
    @JoinColumn
    protected Customer customer;
    @ManyToMany
    @JoinColumn
    private List<Item> items = new ArrayList<>();

    public Buy(LocalDate date, Customer customer, List<Item> items) {
        this.date = date;
        this.customer = customer;
        this.items = items;
    }
}

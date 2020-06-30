package com.item.microservice.item.microservice.services;

import com.item.microservice.item.microservice.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}

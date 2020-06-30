package com.item.microservice.item.microservice.controllers;

import com.item.microservice.item.microservice.models.Item;
import com.item.microservice.item.microservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/list_items")
    public List<Item> listItem() {
        return itemService.findAll();
    }

    @GetMapping("/show/{id}/quantity/{quantity}")
    public Item detailsItem(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }

}

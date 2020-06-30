package com.item.microservice.item.microservice.services;

import com.item.microservice.item.microservice.models.Item;
import com.item.microservice.item.microservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> items = Arrays.asList(restTemplate.getForObject("http://localhost:8001/list_products", Product[].class));
        return items.stream().map( p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariable = new HashMap<String, String>();
        pathVariable.put("id", id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/details/{id}", Product.class, pathVariable);
        return new Item(product, quantity);
    }
}

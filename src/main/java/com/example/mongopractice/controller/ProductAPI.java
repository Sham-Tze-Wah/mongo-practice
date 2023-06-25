package com.example.mongopractice.controller;

import com.example.mongopractice.entity.ProductEntity;
import com.example.mongopractice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class ProductAPI {

    @Autowired
    private ProductRepository productRepository;

    final String ENTITY_NAME = "/product";

    @PostMapping(value = ENTITY_NAME+"/post")
    public ResponseEntity<Object> insertProductIntoDB(){
        System.out.println("Data creation for product started...");
        productRepository.save(new ProductEntity(UUID.randomUUID().toString(),"Seaweed", 12.00, "Good taste", false));
        productRepository.save(new ProductEntity(UUID.randomUUID().toString(),"Cookies", 12.00, "Crunchy", false));
        productRepository.save(new ProductEntity(UUID.randomUUID().toString(),"Breads", 12.00, "Fluffy", false));
        productRepository.save(new ProductEntity(UUID.randomUUID().toString(),"Ramen", 12.00, "Rich in flavour", false));
        productRepository.save(new ProductEntity(UUID.randomUUID().toString(),"Cup Noodles", 12.00, "Tom Yam flavour", false));
        System.out.println("Data creation for product completed...");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = ENTITY_NAME + "/get")
    public ResponseEntity<Object> returnItems(@RequestParam(value = "name", required = false) String name){
        return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.OK);
    }
}

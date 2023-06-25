package com.example.mongopractice.controller;

import com.example.mongopractice.entity.GroceryItem;
import com.example.mongopractice.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ItemAPI {

    final String ENTITY_NAME = "/item";

    @Autowired
    ItemRepository groceryItemRepo;

    //Return ResponseEntity of Object Type
    @PostMapping(value = ENTITY_NAME+"/post")
    public ResponseEntity<Object> saveItems(){
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = ENTITY_NAME+"/get")
    public ResponseEntity<Object> returnItems(@RequestParam(value = "category", required = false) String category){
        return new ResponseEntity<>(groceryItemRepo.findAll(category), HttpStatus.OK);
    }

}

package com.example.mongopractice.repository.item;

import com.example.mongopractice.entity.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {


    @Query("{name:'?0'}")
    GroceryItem findItemByName(String name);

    //https://www.mongodb.com/docs/compass/current/query/filter/
    @Query(value="{category:?0}", fields="{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findAll(String category);

    public long count();

}
package com.example.mongopractice;

import com.example.mongopractice.entity.GroceryItem;
import com.example.mongopractice.repository.item.ItemRepository;
import com.example.mongopractice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
//@EnableJpaRepositories (basePackageClasses = ProductRepository.class)
//@EnableJpaRepositories("com.example.mongopractice.repository.*")
//@ComponentScan(basePackages = { "com.example.mongopractice.*" })
//@EntityScan("com.example.mongopractice.entity.*")
public class MongoPracticeApplication implements CommandLineRunner {

	@Autowired
	ItemRepository groceryItemRepo;

	//new comment
	public static void main(String[] args) {
		SpringApplication.run(MongoPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	void createGroceryItems() {
		System.out.println("Data creation started...");
		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllGroceryItems() {
		groceryItemRepo.findAll().forEach(item -> System.out.println(item.toString()));
	}

	// 2. Get item by name
	public void getGroceryItemByName(String name) {
		System.out.println("Getting item by name: " + name);
		GroceryItem item = groceryItemRepo.findItemByName(name);
		System.out.println(item.toString());
	}

	// 3. Get name and quantity of a all items of a particular category
	public void getItemsByCategory(String category) {
		System.out.println("Getting items for the category " + category);
		List<GroceryItem> list = groceryItemRepo.findAll(category);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfGroceryItems() {
		long count = groceryItemRepo.count();
		System.out.println("Number of documents in the collection: " + count);
	}
}

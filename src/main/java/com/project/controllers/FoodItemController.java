package com.project.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.FoodItem;
import com.project.services.FoodItemService;

@RestController
@RequestMapping(value= {"/api/","/api"})
public class FoodItemController {
	@Autowired
	private FoodItemService foodItemService;

	@GetMapping("{id}")
	public ResponseEntity < FoodItem >  read(@PathVariable("id") String id) {
		FoodItem foodItem = foodItemService.read(id);
		return ResponseEntity.ok().body(foodItem);
	}

	@GetMapping
	public List<FoodItem> readAll(){
		return foodItemService.readAll();
	}
	
	@PostMapping
	public FoodItem create(@RequestBody FoodItem foodItem) {
		return foodItemService.create(foodItem);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<FoodItem> update(@RequestBody FoodItem foodItem,@PathVariable("id") String id) {
		// TODO remove these lines 
		// FoodItem foodItem2 = foodItemRepository.findById(id) . orElseThrow(() -> new ResourceNotFoundException("Food Item with the id : "+id+" not found"));
		// foodItem2.setDescription(foodItem.getDescription());
		// foodItem2.setName(foodItem.getName());
		// foodItem2.setPrice(foodItem.getPrice());
		// foodItemRepository.save(foodItem2);
		FoodItem newFoodItem = foodItemService.update(foodItem, id);
		return ResponseEntity.ok().body(newFoodItem);
	}
	
	@DeleteMapping("{id}")
	public Map<String, Boolean> delete(@PathVariable("id") String id){
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", foodItemService.delete(id));
		return response;
	}	
}

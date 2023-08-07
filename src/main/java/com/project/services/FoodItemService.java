package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exceptions.ResourceNotFoundException;
import com.project.models.FoodItem;
import com.project.repos.FoodItemRepository;

@Service
public class FoodItemService {
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	public FoodItem read(String id){
		FoodItem foodItem = foodItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food Item with the id : "+id+" not found"));
		return foodItem;
	}
	
	public List<FoodItem> readAll(){
		return foodItemRepository.findAll();
	}
	
	public FoodItem create(FoodItem foodItem) {
		// TODO write conditions for checking if the object with the given id is already is not present in the db 
		return foodItemRepository.save(foodItem);
	}
	
	public FoodItem update(FoodItem newFoodItem, String id) {
		FoodItem foodItem = foodItemRepository.findById(id) . orElseThrow(() -> new ResourceNotFoundException("Food Item with the id : "+id+" not found"));
		foodItem.setName(newFoodItem.getName());
		foodItem.setPrice(newFoodItem.getName());
		foodItem.setDescription(newFoodItem.getDescription());
		foodItem.setRating(newFoodItem.getRating());
		foodItem.setImageBase64(newFoodItem.getImageBase64());
		foodItemRepository.save(foodItem);
		return foodItem;
	}
	
	public Boolean delete(String id) {
		try{
			FoodItem foodItem = foodItemRepository.findById(id) .orElseThrow(()->new ResourceNotFoundException("Food Item with the id : "+id+" not found"));
			foodItemRepository.delete(foodItem);
		}catch(ResourceNotFoundException exception){
			return false; 
		}
		return true;
	}
	
	public void deleteAll() {
		foodItemRepository.deleteAll();
	}
	
}

package com.project.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.models.FoodItem;

public interface FoodItemRepository extends  MongoRepository<FoodItem, String> { 
}

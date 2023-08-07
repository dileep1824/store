package com.project.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class FoodItem {
	@Id
	private String id;
	private String name;
	private String description;
	private String price;
	private int rating ; 
	private String imageBase64; 	
}

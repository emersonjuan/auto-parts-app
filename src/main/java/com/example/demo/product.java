package com.example.demo;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class product {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String nameString;
	double price;
	int NumberInStock;
	String descriptionString;
	double rating;
	String specificationString;
	String[] reviews;
	@Column
	String Link;
	


    //product with name of product, price, number in stock, description, rating, specifications, reviews,
	public product(String nameString, double price, int numberInStock, String descriptionString, double rating,
			String specificationString, String[] reviews, String Link) {
		super();
		this.nameString = nameString;
		this.price = price;
		this.NumberInStock = numberInStock;
		this.descriptionString = descriptionString;
		this.rating = rating;
		this.specificationString = specificationString;
		this.reviews = reviews;
		this.Link = Link;
	}




	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNameString() {
		return nameString;
	}





	public void setNameString(String nameString) {
		this.nameString = nameString;
	}





	public double getPrice() {
		return price;
	}





	public void setPrice(double price) {
		this.price = price;
	}





	public int getNumberInStock() {
		return NumberInStock;
	}





	public void setNumberInStock(int numberInStock) {
		NumberInStock = numberInStock;
	}





	public String getDescriptionString() {
		return descriptionString;
	}





	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}





	public double getRating() {
		return rating;
	}





	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getSpecificationString() {
		return specificationString;
	}



	public void setSpecificationString(String specificationString) {
		this.specificationString = specificationString;
	}


	public String[] getReviews() {
		return reviews;
	}


	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}

	

	public product() {
		
	}





	public String getLink() {
		return Link;
	}





	public void setLink(String link) {
		Link = link;
	}

	
	

}

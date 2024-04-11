package com.example.demo;

import java.awt.Image;
import java.util.List;

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
	String ImageSrc;
	


    //product with name of product, price, number in stock, description, rating, specifications, reviews
	public product(String nameString, double price, int numberInStock, String descriptionString, double rating,
			String specificationString, String[] reviews,String ImageSrc) {
		super();
		
		this.ImageSrc=ImageSrc;
		this.nameString = nameString;
		this.price = price;
		NumberInStock = numberInStock;
		this.descriptionString = descriptionString;
		this.rating = rating;
		this.specificationString = specificationString;
		this.reviews = reviews;
	}

	public String getImageSrc() {
		return ImageSrc;
	}

	public void setImageSrc(String imageSrc) {
		ImageSrc = imageSrc;
	}

	public String getSpecificationString() {
		return specificationString;
	}

	public void setSpecificationString(String specificationString) {
		this.specificationString = specificationString;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
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
	
	
	public String[] getReviews() {
		return reviews;
	}

	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}
	public product() {
		
	}

	
	

}

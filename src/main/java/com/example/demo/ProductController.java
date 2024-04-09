package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public List<product> getProducts() {
		List<product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/products/{id}")
	public Optional<product> getProductsById(@PathVariable long id) {
		Optional<product> product = productRepository.findById(id);
		return product;
	}

	@GetMapping("/products/{id}/specifications")
	public ResponseEntity<String> getProductSpecifications(@PathVariable long id) {
		Optional<product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with ID: " + id);
		}

		product product = productOptional.get();

		String specifications = product.getSpecificationString();
		System.out.println("Retrieved specificationString: " + specifications);

		return ResponseEntity.ok(specifications);
	}

	@GetMapping("/products/{id}/stock")
	public ResponseEntity<Double> getProductStock(@PathVariable long id) {
		Optional<product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with ID: " + id);
		}

		product product = productOptional.get();

		double numberInStock = product.getNumberInStock();

		return ResponseEntity.ok(numberInStock);
	}

	@GetMapping("/products/{id}/reviews")
	public ResponseEntity<String[]> getProductReviews(@PathVariable long id) {
		Optional<product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with ID: " + id);
		}

		product product = productOptional.get();
		String[] reviews = product.getReviews();
		return ResponseEntity.ok(reviews);
	}

	@PostMapping("/products")
	public ResponseEntity<product> postMethodName(@RequestBody product product) {
		System.out.println(product);
		productRepository.save(product);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		productRepository.deleteById(id);
	}

}

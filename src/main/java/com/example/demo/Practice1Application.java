package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@SpringBootApplication

public class Practice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice1Application.class, args);
	}
	// creating products on load

	@Bean
	ApplicationRunner initProducts(ProductRepository productRepository) {

		List<String[]> productReviews = new ArrayList<>(Arrays.asList(
				new String[] { "Great stopping power, minimal noise." },
				new String[] { "Easy to install, noticeable improvement in braking." },
				new String[] { "Nice and bright and comes with adapter built in" },
				new String[] {
						"Bought as replacement for GMC Sierra. Fit perfectly and installed with not issues. Works great!" },
				new String[] { "Best tire for lower mainland winter. Grips well in slippery conditions." }));
		List<String> productName = new ArrayList<String>(Arrays.asList(
				"Brake Pads (Front)",
				"Air Filter",
				"H11 MotoMaster OEPLUS® LED Headlight Bulb",
				"MOTOMASTER Size 48 Battery",
				"Michelin SNOW Winter Tire"));
		List<Double> productPrice = new ArrayList<Double>(Arrays.asList(77.99, 15.50, 99.99, 218.99, 167.99));
		List<Integer> productStock = new ArrayList<Integer>(Arrays.asList(15, 40, 7, 13, 5));
		List<String> productDesc = new ArrayList<String>(Arrays.asList(
				"Semi-metallic brake pads for quiet operation and excellent stopping power.",
				"High-quality air filter for improved engine performance and fuel efficiency.",
				"MotoMaster H11 OEPLUS® LED Headlights are a direct LED replacement for existing halogen bulbs. No conversion kit required",
				"The MotoMaster OEPLUS Group Size 48 (H6/L3) Battery offers superior power, performance, and durability.",
				"This tire’s innovative Intelli-Grip technology delivers lasting traction on snow and ice that resists hydroplaning. "));
		List<Double> productRating = new ArrayList<Double>(Arrays.asList(4.8, 4.3, 3.7, 4.4, 4.6));
		List<String> producSpec = new ArrayList<String>(Arrays.asList(
				"Fits compatible car models",
				"Fits compatible car models",
				"Produces 6000K lighting compared to regular halogen lights that on average produce 3000K light",
				"Ideal for newer vehicles with high electrical demands, aging vehicles now needing more power to turn over.",
				"On-Off Road Rating Highway"));
		List<String> ImageSources = new ArrayList<String>(Arrays.asList(
				"/assets/brakepad.jpeg",
				"/assets/filter.jpeg",
				"/assets/headlight.jpeg",
				"/assets/battery.jpeg",
				"/assets/tire.jpeg"));

		return ArgsAnnotationPointcut -> {

			for (int i = 0; i < productName.size(); i++) {
				productRepository.save(new product(
						productName.get(i),
						productPrice.get(i),
						productStock.get(i),
						productDesc.get(i),
						productRating.get(i),
						producSpec.get(i),
						productReviews.get(i),
						ImageSources.get(i)));
			}

		};
	}

	@Bean
	ApplicationRunner initUsers(UserRepository userRepository) {

		return args -> {
			List<User> users = initializedUsers();
			for (User user : users) {
				userRepository.save(new User(user.getfName(), user.getlName(),
						user.getEmail(), user.getPassword(),user.getRole() ));
			}
		};
	}

	// Method to initialize the database
	public static List<User> initializedUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("Dhrisya ", "Suseelan", "dhrisya@test.ca", "2025", "Admin"));
		users.add(new User("Emerson", "Silva", "emerson@test.ca", "2024", "Admin"));
		users.add(new User("Michael", "Felker", "michael@test.ca", "2023", "Admin"));
		users.add(new User("Rubani", "Rubani", "rubani@test.ca", "2022", "Admin"));
		users.add(new User("Rafael", "Oliveira", "rafael@test.ca", "2021", "User"));
		users.add(new User("Corey", "La", "corey@test.ca", "2020", "User"));

		return users;
	}

}

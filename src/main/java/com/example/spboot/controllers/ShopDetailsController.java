package com.example.spboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spboot.models.ShoppingCart;
import com.example.spboot.models.Shops;
import com.example.spboot.repository.ShopDetailsRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/app")
public class ShopDetailsController {
	
	
	
	@Autowired
	private ShopDetailsRepository sdRepo;
	
	
	
	@GetMapping("/shops")
	public List<Shops> getAllShops() {
		List<Shops> theEmployees = sdRepo.getAllShops();
		return theEmployees;
	}
}

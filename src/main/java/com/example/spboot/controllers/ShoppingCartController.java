package com.example.spboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spboot.models.ShoppingCart;
import com.example.spboot.models.Shops;
import com.example.spboot.repository.ShopDetailsRepository;
import com.example.spboot.repository.ShoppingCartRepository;
import com.example.spboot.service.ShoppingCartService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/app")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository shoppingRepo;
	
	@Autowired
	private ShoppingCartService shoppingcartService;
	
	@Autowired
	private ShopDetailsRepository detailRepo;

	@GetMapping("/items")
	public List<ShoppingCart> getAllEmployees() {
		List<ShoppingCart> theEmployees = shoppingRepo.getAllItems();
		return theEmployees;
	}

	@GetMapping("/itemDetails/{itemId}")
	public ShoppingCart geemployeeById(@PathVariable("itemId") String theId) {
		ShoppingCart shoppingcrt = shoppingRepo.findByItemId(Integer.parseInt(theId));

		if (shoppingcrt == null) {
			throw new RuntimeException("The given id is not found in Database =>" + theId);

		}
		return shoppingcrt;

	}

	@PostMapping("/item")
	public ShoppingCart saveEmployee(@RequestBody ShoppingCart shoppingcrt) {
		
		shoppingRepo.save(shoppingcrt);
		Shops spbe=new Shops();
		spbe.setAddress("banglore");
		spbe.setName(shoppingcrt.getShopName());

		spbe.setStatusId(1);
		detailRepo.save(spbe);
		return shoppingcrt;
	}

	
	@PutMapping("/item/{itemId}")
	public ShoppingCart updateEmployeeByID(@RequestBody ShoppingCart item,
			@PathVariable("itemId") int theId) {
		System.out.println("item"+item.getItemName());
		ShoppingCart spr=shoppingRepo.findByItemId(theId);
		
		if(spr.getId()>0) {
			spr.setItemName(item.getItemName());
			spr.setShopName(item.getShopName());
			spr.setTotalItems(item.getTotalItems());
			spr.setStatus(item.isStatus());
			shoppingRepo.save(spr);
			Shops spbe=new Shops();
			spbe.setAddress("banglore");
			spbe.setName(item.getShopName());

			spbe.setStatusId(1);

			detailRepo.save(spbe);
		}
		return spr;
	}
	
	
	@DeleteMapping("/item/{itemId}")
	public void deleteEmployeeById(@PathVariable("itemId") String theId) {
		shoppingcartService.deleteEmployee(Integer.parseInt(theId));
		
	}

	
	
	
	
}

package com.example.spboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spboot.models.ShoppingCart;
import com.example.spboot.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository repo;
	
	public void deleteEmployee(int theId) {
		if (theId>0) {
			
		ShoppingCart cart=repo.findByItemId(theId);
			if (cart.isStatus()) {

				cart.setStatus(false);
				repo.save(cart);
				
			}
		}else {
			throw new RuntimeException("given id is not present in DB:");
		}
		
	

}
}

package com.example.spboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spboot.models.ShoppingCart;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	@Query(nativeQuery = true ,value="select * from shopping_cart where status='true' order by id desc")
	public List<ShoppingCart> getAllItems() ;
	
	@Query(nativeQuery = true ,value="select * from shopping_cart where id=?")
	public ShoppingCart findByItemId(@Param("itemid") int theId);
	
	@Query(nativeQuery = true ,value="select * from shopping_cart where id=?")
	public void updatebyItemId(ShoppingCart theEmployee, int theId);
		
	

}

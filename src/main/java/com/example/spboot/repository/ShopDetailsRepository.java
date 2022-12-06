package com.example.spboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.spboot.models.ShoppingCart;
import com.example.spboot.models.Shops;

public interface ShopDetailsRepository extends JpaRepository<Shops, Long> {

	@Query(nativeQuery =true,value= "select * From shops")
	public List<Shops> getAllShops();

}

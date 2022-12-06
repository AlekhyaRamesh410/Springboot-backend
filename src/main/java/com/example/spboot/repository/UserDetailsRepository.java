package com.example.spboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spboot.models.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	@Query(nativeQuery = true ,value="select * from user_details where user_name=? and password=?")
	public UserDetails getUserAccountDeatils(@Param("username") String userName,@Param("password") String password );
	
	@Query(nativeQuery = true ,value="select * from user_details")
	public List<UserDetails> getUsersList();
	
	
	
}

package com.example.spboot.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spboot.models.UserDetails;
import com.example.spboot.repository.UserDetailsRepository;

@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsRepository userRepo;

	@GetMapping("/")
	public String getHello() {
		return "Hello World";
	}

	@GetMapping("/users")
	public HashMap<String, Object> getUsers(HttpServletRequest request, HttpServletResponse response) {
		List<UserDetails> uses = userRepo.getUsersList();
		HashMap<String, Object> data = new HashMap<>();
		try {

			for (UserDetails user : uses) {
				data.put("userName", user.getUserName());
				data.put("email", user.getUserName());
				data.put("status", user.getUserName());
				data.put("userType", user.getUserName());
			}
			data.put("data", data);
			data.put("status", "success");
			data.put("msg", "User details retried successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@PutMapping("/addUser")
	public HashMap<String, Object> addUser(@RequestBody UserDetails userDetails, HttpServletRequest request,
			HttpServletResponse response) {

		HashMap<String, Object> data = new HashMap<>();
		try {
		UserDetails ubean = new UserDetails();
		ubean.setEmail(userDetails.getEmail());
		ubean.setFirstName(userDetails.getFirstName());
		ubean.setLastName(userDetails.getLastName());
		ubean.setUserName(userDetails.getUserName());
		ubean.setUserType(userDetails.getUserType());
		ubean.setStatus(1);

		userRepo.save(ubean);
		data.put("status", "success");
		data.put("msg", "User  is created successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}

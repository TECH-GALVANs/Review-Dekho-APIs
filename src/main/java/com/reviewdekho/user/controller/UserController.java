package com.reviewdekho.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.user.model.User;
import com.reviewdekho.user.service.UserService;

@RequestMapping( "api/user" )
@RestController
public class UserController {
	private UserService userService;
	@Autowired
	public UserController( UserService userService ) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity add( @RequestBody User user ) {
		System.out.println("From Controller-add");
		userService.add(user);
		return ResponseEntity.status(200).body(user);
	}
	
	@GetMapping
	public List<User> get(){
		System.out.println("From Controller-get");
		return userService.get();
	}
	
	@GetMapping(path="{id}")
	public User getById( @PathVariable("id") Integer user_id ) {
		System.out.println("From Controller-get-id"+user_id);
		return userService.getById(user_id);
	}
	
	@GetMapping(path="/emailid/{email_id}")
	public User getByEmailId( @PathVariable("email_id") String email_id ) {
		System.out.println("From Controller-get-email-id"+email_id);
		return userService.getByEmailId( email_id );
	}
	
	@GetMapping(path="/username/{user_name}")
	public User getByUserName( @PathVariable("user_name") String user_name ) {
		System.out.println("From Controller-get-user-name"+user_name);
		return userService.getByUserName( user_name );
	}
	
	@PutMapping(path="{id}")
	public void update( @RequestBody User user, @PathVariable("id") Integer user_id ) {
		System.out.println("From Controller-update");
		userService.update(user, user_id);
	}
	
	@PutMapping(path="/role/{id}")
	public void updateRole( @RequestBody User user, @PathVariable("id") Integer user_id ) {
		System.out.println("From Controller-update");
		userService.updateRole(user, user_id);
	}
	
	@PutMapping(path="/forgotpassword/{id}")
	public void forgotPassword( @RequestBody User user, @PathVariable("id") Integer user_id ) {
		System.out.println("From Controller-update");
		userService.forgotPassword(user, user_id);
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer user_id ) {
		System.out.println("From Controller-delete");
		userService.delete(user_id);
	}
}

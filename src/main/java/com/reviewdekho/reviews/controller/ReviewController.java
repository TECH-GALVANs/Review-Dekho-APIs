package com.reviewdekho.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.reviews.services.ReviewService;
import com.reviewdekho.user.model.User;

@RequestMapping( "api/review" )
@RestController
public class ReviewController {
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController( ReviewService reviewService ) {
		System.out.println("From Controller-constructor");
		this.reviewService = reviewService;
	}
	
	@PostMapping
	public void add( @RequestBody Review review ) {
		review.setProduct( reviewService.getProductById( review.getProduct().getProduct_id() ) );
		review.setUser( reviewService.getUserById( review.getUser().getUser_id() ) );
		System.out.println("From Controller-add");
		reviewService.add(review);
	}
	
	@GetMapping
	public List<Review> get(){
		System.out.println("From Controller-get");
		return reviewService.get();
	}
	
	@GetMapping(path="{id}")
	public Review getById( @PathVariable("id") Integer review_id ) {
		System.out.println("From Controller-get-id"+review_id);
		return reviewService.getById(review_id);
	}
	
	@GetMapping(path="/user/{id}")
	public List<Review> getReviewsByUserId( @PathVariable("id") Integer userId ) {
		System.out.println("From Controller-get-id"+userId);
		User user = reviewService.getUserById(userId);
		return reviewService.getReviewsByUser(user);
	}
	
	@GetMapping(path="/category/{id}")
	public List<Review> getReviewsByCategoryId( @PathVariable("id") Integer categoryId ) {
		System.out.println("From Controller-get-id"+categoryId);
		return reviewService.getReviewByCategoryId(categoryId);
	}
	
	@PutMapping(path="{id}")
	public void update( @RequestBody Review review, @PathVariable("id") Integer review_id ) {
		review.setProduct( reviewService.getProductById( review.getProduct().getProduct_id() ) );
		review.setUser( reviewService.getUserById( review.getUser().getUser_id() ) );
		System.out.println("From Controller-update");
		reviewService.update(review, review_id);
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer review_id ) {
		System.out.println("From Controller-delete");
		reviewService.delete(review_id);
	}
}

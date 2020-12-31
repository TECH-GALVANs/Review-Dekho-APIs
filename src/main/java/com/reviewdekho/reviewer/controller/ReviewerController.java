package com.reviewdekho.reviewer.controller;

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

import com.reviewdekho.reviewer.model.Reviewer;
import com.reviewdekho.reviewer.service.ReviewerService;
import com.reviewdekho.reviews.model.Review;

@RequestMapping("api/reviewer")
@RestController
public class ReviewerController {
	private ReviewerService reviewerService;
	
	@Autowired
	public ReviewerController( ReviewerService reviewerService ) {
		this.reviewerService = reviewerService;
	}
	
	@PostMapping
	public Reviewer add( @RequestBody Reviewer reviewer ) {
		reviewer.setUser( reviewerService.getUserById( reviewer.getUser().getUser_id() ) );
		System.out.println("From Controller-add");
		return reviewerService.add(reviewer);
	}
	
	@GetMapping
	public List<Reviewer> get(){
		System.out.println("From Controller-get");
		return reviewerService.get();
	}
	
	@GetMapping(path="{id}")
	public Reviewer get( @PathVariable("id") Integer reviewerId ) {
		System.out.println("From Controller-get-id"+reviewerId);
		return reviewerService.get(reviewerId);
	}
	
	@PutMapping(path="{id}")
	public Reviewer update( @RequestBody Reviewer reviewer, @PathVariable("id") Integer reviewerId ) {
		System.out.println("From Controller-update");
		return reviewerService.update( reviewer, reviewerId );
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer reviewerId ) {
		System.out.println("From Controller-delete");
		reviewerService.delete(reviewerId);
	}
}

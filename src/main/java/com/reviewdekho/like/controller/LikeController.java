package com.reviewdekho.like.controller;

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

import com.reviewdekho.like.model.Like;
import com.reviewdekho.like.service.LikeService;
import com.reviewdekho.reviews.model.Review;

@RequestMapping( "api/like" )
@RestController
public class LikeController {
	private LikeService likeService;
	
	@Autowired
	public LikeController( LikeService likeService ) {
		System.out.println("From Controller-constructor");
		this.likeService = likeService;
	}
	
	@PostMapping
	public void add( @RequestBody Like like ) {
		System.out.println("From Controller-add");
		like.setReview( likeService.getReviewById( like.getReview().getReview_id() ) );
		like.setUser( likeService.getUserById( like.getUser().getUser_id() ) );
		likeService.add(like);
	}
	
	@GetMapping
	public List<Like> get(){
		System.out.println("From Controller-get");
		return likeService.get();
	}
	
	@GetMapping(path="{id}")
	public Like getById( @PathVariable("id") Integer like_id ) {
		System.out.println("From Controller-get-id"+like_id);
		return likeService.getById(like_id);
	}
	
	@GetMapping(path="/review/{id}")
	public List<Like> getByReviewId( @PathVariable("id") Integer review_id ) {
		System.out.println("From Controller-get-reviewid"+review_id);
		Review review = likeService.getReviewById(review_id);
		return likeService.getByReviewId(review);
	}
	
	@PutMapping(path="{id}")
	public void update( @RequestBody Like like, @PathVariable("id") Integer like_id ) {
		System.out.println("From Controller-update");
		like.setReview( likeService.getReviewById( like.getReview().getReview_id() ) );
		like.setUser( likeService.getUserById( like.getUser().getUser_id() ) );
		likeService.update(like, like_id);
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer like_id ) {
		System.out.println("From Controller-delete");
		likeService.delete(like_id);
	}
}

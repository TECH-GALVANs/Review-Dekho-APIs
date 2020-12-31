package com.reviewdekho.comment.controller;

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

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.comment.service.CommentService;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.reviews.services.ReviewService;

@RequestMapping("api/comment")
@RestController
public class CommentController {
	private CommentService commentService;
	private ReviewService reviewService;
	
	@Autowired
	public CommentController( CommentService commentService ) {
		System.out.println("From Controller-constructor");
		this.commentService = commentService;
		
	}
	
	@PostMapping
	public void add( @RequestBody Comment comment ) {
		System.out.println("From Controller-add");
		commentService.add(comment);
	}
	
	@GetMapping
	public List<Comment> get(){
		System.out.println("From Controller-get");
		return commentService.get();
	}
	
	@GetMapping(path="{id}")
	public Comment getById( @PathVariable("id") Integer comment_id ) {
		System.out.println("From Controller-get-id"+comment_id);
		return commentService.getById(comment_id);
	}
	
	@GetMapping(path="/review/{id}")
	public List<Comment> getByReview( @PathVariable("id") Integer reviewId ) {
		System.out.println("From Controller-get-id"+reviewId);
		Review review = commentService.getByReviewId(reviewId);
		return commentService.getByReview(review);
	}
	
	@PutMapping(path="{id}")
	public void update( @RequestBody Comment comment, @PathVariable("id") Integer comment_id ) {
		System.out.println("From Controller-update");
		commentService.update(comment, comment_id);
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer comment_id ) {
		System.out.println("From Controller-delete");
		commentService.delete(comment_id);
	}
}

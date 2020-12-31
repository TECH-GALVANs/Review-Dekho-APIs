package com.reviewdekho.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.comment.dao.CommentDao;
import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.reviews.model.Review;

@Service
public class CommentService {
	private CommentDao dao;
	
	@Autowired
	public CommentService( @Qualifier("comment") CommentDao dao ) {
		this.dao = dao;
	}
	
	public void add( Comment comment ) {
		dao.add(comment);
	}
	
	public List<Comment> get() {
		return dao.get();
	}
	
	public Comment getById( Integer comment_id ) {
		return dao.getById(comment_id);
	}
	
	public List< Comment > getByReview( Review review ){
		return dao.getByReview(review);
	}
	
	public void update( Comment comment, Integer comment_id ) { 
		dao.update(comment, comment_id);
	}
	
	public void delete( Integer comment_id ) {
		dao.delete(comment_id);
	}
	
	public Review getByReviewId( Integer reviewId ) {
		return dao.getByReviewId(reviewId);
	}
}

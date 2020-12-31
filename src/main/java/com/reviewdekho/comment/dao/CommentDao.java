package com.reviewdekho.comment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.reviews.dao.ReviewDao;
import com.reviewdekho.reviews.dao.ReviewDaoI;
import com.reviewdekho.reviews.model.Review;

@Repository("comment")
public class CommentDao {
	@Autowired
	CommentDaoI commentRepo;
	@Autowired
	ReviewDaoI reviewDao;
	
	public void add( Comment comment ) {
		commentRepo.save( comment );
	}
	
	public List<Comment> get(){
		return commentRepo.findAll();
	}
	
	public Comment getById( final Integer comment_id ) {
		return commentRepo.findById(comment_id).orElse(null);
	}
	
	public List< Comment > getByReview( Review review ){
		return commentRepo.findByReview(review);
	}
	
	public void update( Comment comment, Integer comment_id ) {
		Comment commentTo = getById(comment_id);
		commentTo.setIsDeleted( true );
		commentRepo.save(commentTo);
	}
	
	public void delete( Integer comment_id ) {
		Comment commentTo = getById(comment_id);
		commentTo.setIsDeleted( true );
		commentRepo.save(commentTo);
	}
	
	public Review getByReviewId( Integer reviewId ) {
		return reviewDao.findById( reviewId ).orElse(null);
	}
}


package com.reviewdekho.like.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.like.model.Like;
import com.reviewdekho.reviews.dao.ReviewDaoI;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.dao.UserDaoI;
import com.reviewdekho.user.model.User;

@Repository("like")
public class LikeDao {
	@Autowired
	LikeDaoI likeRepo;
	
	@Autowired
	ReviewDaoI reviewRepo;
	
	@Autowired
	UserDaoI userRepo;
	
	public void add( Like like ) {
		likeRepo.save( like );
	}
	
	public List<Like> get(){
		return likeRepo.findAll();
	}
	
	public Like getById( final Integer like_id ) {
		return likeRepo.findById(like_id).orElse(null);
	}
	
	public List< Like > getByReviewId( Review review ){
		return likeRepo.findByReview(review);
	}
	
	public void update( Like like, Integer like_id ) {
		Like likeTo = getById(like_id);
		// As we are going to delete softly, we are just update the values of isLike in this table !!!
		likeTo.setIsLiked( like.getIsLiked() );
		
		likeRepo.save(likeTo);
	}
	
	public void delete( Integer like_id ) {
//		And we not remove the data in the table, we just change the value of isLike !!!
		Like likeTo = getById(like_id);
		likeTo.setIsLiked( false );
		likeRepo.save(likeTo);
	}
	
	public User getUserById( Integer userId ) {
		return userRepo.findById( userId ).orElse( null );
	}
	
	public Review getReviewById( Integer reviewId ) {
		return reviewRepo.findById( reviewId ).orElse( null );
	}
	
}
package com.reviewdekho.like.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.like.dao.LikeDao;
import com.reviewdekho.like.model.Like;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Service
public class LikeService {
	private LikeDao dao;
	
	@Autowired
	public LikeService( @Qualifier("like") LikeDao dao ) {
		this.dao = dao;
	}
	
	public void add( Like like ) {
		dao.add(like);
	}
	
	public List<Like> get() {
		return dao.get();
	}
	
	public Like getById( Integer like_id ) {
		return dao.getById(like_id);
	}
	
	public List< Like > getByReviewId( Review review ){
		return dao.getByReviewId(review);
	}
	
	public void update( Like like, Integer like_id ) { 
		dao.update(like, like_id);
	}
	
	public void delete( Integer like_id ) {
		dao.delete(like_id);
	}
	
	public User getUserById( Integer userId ) {
		return dao.getUserById(userId);
	}
	
	public Review getReviewById( Integer reviewId ) {
		return dao.getReviewById(reviewId);
	}
}

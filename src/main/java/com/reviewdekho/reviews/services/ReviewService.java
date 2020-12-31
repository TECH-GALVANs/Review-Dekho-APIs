package com.reviewdekho.reviews.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.reviews.dao.ReviewDao;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Service
public class ReviewService {
	private ReviewDao dao;
	
	@Autowired
	public ReviewService( @Qualifier("review") ReviewDao dao ) {
		this.dao = dao;
	}
	
	public void add( Review review ) {
		dao.add(review);
	}
	
	public List<Review> get() {
		return dao.get();
	}
	
	public List<Review> getReviewsByUser( User user ){
		return dao.getReviewsByUser(user);
	}
	
	public List<Review> getReviewByCategoryId( Integer categoryId ){
		return dao.getReviewByCategoryId(categoryId);
	}
	
	public Review getById( Integer review_id ) {
		return dao.getById(review_id);
	}
	
	public void update( Review review, Integer review_id ) { 
		dao.update(review, review_id);
	}
	
	public void delete( Integer review_id ) {
		dao.delete(review_id);
	}
	
	public Product getProductById( Integer productId ) {
		return dao.getProductById(productId);
	}
	
	public User getUserById( Integer userId ) {
		return dao.getUserById(userId);
	}
	
}

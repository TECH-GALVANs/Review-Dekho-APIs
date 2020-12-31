package com.reviewdekho.reviews.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.product.dao.ProductDao;
import com.reviewdekho.product.dao.ProductDaoI;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.dao.ProductImageDao;
import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.dao.UserDaoI;
import com.reviewdekho.user.model.User;

@Repository( "review" )
public class ReviewDao {
	@Autowired
	ReviewDaoI reviewDao;
	
	@Autowired
	UserDaoI userRepo;
	
	@Autowired
	ProductImageDao productRepo;
	
	@Autowired
	ProductDao productDao;
	
	public int add( Review review ) {
		reviewDao.save( review );
		return 1;
	}
	
	public List< Review > get(){
		return reviewDao.findAll();
	}
	
	public List<Review> getReviewsByUser( User user ){
		return reviewDao.findByUser(user);
	}
	
	public List<Review> getReviewByCategoryId( Integer categoryId ){
		List<Review> reviews = get();
		List<Review> reviewsByCat = new ArrayList<Review>();
		
		for( Review review : reviews ) {
			if( review.getProduct().getSubCategory().getCategory().getCategory_id() == categoryId ) {
				reviewsByCat.add( review );
			}
		}
		
		return reviewsByCat;
	}
	
	public Review getById( Integer reviewId ) {
		return reviewDao.findById( reviewId ).orElse(null);
	}
	
	public int update( Review review, Integer reviewId ) {
		Review reviewN = getById( reviewId );
		
		reviewN.setProduct( review.getProduct() );
		reviewN.setUser( review.getUser() );
		reviewN.setReview_desc( review.getReview_desc() );
		
		reviewDao.save( reviewN );
		return 1;
	}
	
	public int delete( Integer reviewId ) {
		reviewDao.deleteById( reviewId );
		return 1;
	}
	
//	public ProductImage getProductById( Product product ) {
//		return productRepo.getByProduct( product );
//	}
//	
	public Product getProductById( Integer productId ) {
		return productDao.getById( productId );
	}
	
	public User getUserById( Integer userId ) {
		return userRepo.findById( userId ).orElse(null);
	}
	
}

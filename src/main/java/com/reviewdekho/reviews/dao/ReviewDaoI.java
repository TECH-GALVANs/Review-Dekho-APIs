package com.reviewdekho.reviews.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

public interface ReviewDaoI extends JpaRepository<Review, Integer> {
	public List<Review> findByUser(User user);
	public List<Review> findByProduct(ProductImage product);
}

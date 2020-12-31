package com.reviewdekho.like.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.like.model.Like;
import com.reviewdekho.reviews.model.Review;

public interface LikeDaoI extends JpaRepository<Like, Integer> {
	public List<Like> findByReview(Review review);
}

package com.reviewdekho.comment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.reviews.model.Review;

public interface CommentDaoI extends JpaRepository<Comment, Integer> {
	public List<Comment> findByReview(Review review);
}

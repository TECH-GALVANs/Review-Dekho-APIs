package com.reviewdekho.like.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Entity
@Table(name="like_master")
public class Like {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer like_id;
	@ManyToOne()
	@JoinColumn( name="review_id" ) 
	private Review review;
	@ManyToOne()
	@JoinColumn( name="user_id" ) 
	private User user;
	private Boolean isLiked = true;
	@CreationTimestamp
	private Timestamp created_at;
	@UpdateTimestamp
	private Timestamp updated_at;
	
	public Like() {}
	
	public Like(Integer like_id, Review review, User user, Boolean isLiked, Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.like_id = like_id;
		this.review = review;
		this.user = user;
		this.isLiked = isLiked;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Integer getLike_id() {
		return like_id;
	}
	public void setLike_id(Integer like_id) {
		this.like_id = like_id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public Boolean getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

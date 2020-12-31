package com.reviewdekho.comment.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Entity
@Table(name="comment_master")
public class Comment {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer comment_id;
	private String comment_desc;
	@ManyToOne()
	@JoinColumn( name="review_id" ) 
	private Review review;
	@ManyToOne()
	@JoinColumn( name="user_id" ) 
	private User user;
	@CreationTimestamp
	private Timestamp comment_created_at;
	@UpdateTimestamp
	private Timestamp comment_updated_at;
	private Boolean isDeleted = false;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	public Comment() {}
	
	public Comment(Integer comment_id,String comment_desc, Review review, User user , Timestamp comment_created_at,
			Timestamp comment_updated_at, Boolean isDeleted ) {
		super();
		this.comment_id = comment_id;
		this.comment_desc = comment_desc;
		this.review = review;
		this.user = user;
		this.comment_created_at = comment_created_at;
		this.comment_updated_at = comment_updated_at;
	}
	
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_desc() {
		return comment_desc;
	}
	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
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

	public Date getComment_created_at() {
		return comment_created_at;
	}
	public void setComment_created_at(Timestamp comment_created_at) {
		this.comment_created_at = comment_created_at;
	}
	public Date getComment_updated_at() {
		return comment_updated_at;
	}
	public void setComment_updated_at(Timestamp comment_updated_at) {
		this.comment_updated_at = comment_updated_at;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}

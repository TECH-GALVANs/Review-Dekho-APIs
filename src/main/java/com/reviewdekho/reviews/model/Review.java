package com.reviewdekho.reviews.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.user.model.User;

@Entity
@Table( name="review_master" )
public class Review {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer review_id;
	private String review_desc;
	@ManyToOne()
	@JoinColumn( name="user_id" )
	private User user;
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name="product_id" )
	private Product product;
	@CreationTimestamp
	private Timestamp review_added_at;
	@UpdateTimestamp
	private Timestamp review_updated_at;
		
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	public Review() { }

	public Review(Integer review_id, String review_desc, User user, Product product, Timestamp review_added_at,
			Timestamp review_updated_at) {
		super();
		this.review_id = review_id;
		this.review_desc = review_desc;
		this.user = user;
		this.product = product;
		this.review_added_at = review_added_at;
		this.review_updated_at = review_updated_at;
	}

	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	public String getReview_desc() {
		return review_desc;
	}
	public void setReview_desc(String review_desc) {
		this.review_desc = review_desc;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Timestamp getReview_added_at() {
		return review_added_at;
	}
	public void setReview_added_at(Timestamp review_added_at) {
		this.review_added_at = review_added_at;
	}
	public Timestamp getReview_updated_at() {
		return review_updated_at;
	}
	public void setReview_updated_at(Timestamp review_updated_at) {
		this.review_updated_at = review_updated_at;
	}
}

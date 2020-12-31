package com.reviewdekho.productImage.model;

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

@Entity
@Table(name="product_image_master")
public class ProductImage {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer image_id;
	@ManyToOne
	@JoinColumn( name="product_id" ) 
	private Product product;
	private String image;
	@CreationTimestamp
	private Timestamp image_created_at;
	@UpdateTimestamp
	private Timestamp image_updated_at;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public ProductImage() {}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getImage_created_at() {
		return image_created_at;
	}

	public void setImage_created_at(Timestamp image_created_at) {
		this.image_created_at = image_created_at;
	}

	public Timestamp getImage_updated_at() {
		return image_updated_at;
	}

	public void setImage_updated_at(Timestamp image_updated_at) {
		this.image_updated_at = image_updated_at;
	}
}
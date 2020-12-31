package com.reviewdekho.product.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.subcategory.model.SubCategory;

@Entity
@Table(name="product_master")
public class Product {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer product_id;
	@ManyToOne()
	@JoinColumn( name="sub_category_id" ) 
	private SubCategory subCategory;

	private String product_name;
	private String image;
	private String imageType;
	private String product_desc;
	private Integer product_price;

	@CreationTimestamp
	private Timestamp product_created_at;
	@UpdateTimestamp
	private Timestamp product_updated_at;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public Product() {}
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getProduct_name() {
		return product_name;
	}
	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Timestamp getProduct_created_at() {
		return product_created_at;
	}

	public void setProduct_created_at(Timestamp product_created_at) {
		this.product_created_at = product_created_at;
	}

	public Timestamp getProduct_updated_at() {
		return product_updated_at;
	}

	public void setProduct_updated_at(Timestamp product_updated_at) {
		this.product_updated_at = product_updated_at;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}


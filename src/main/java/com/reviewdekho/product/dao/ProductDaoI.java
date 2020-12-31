package com.reviewdekho.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.model.SubCategory;

public interface ProductDaoI extends JpaRepository<Product, Integer> {
	List<Product> findBySubCategory(SubCategory subCategory);
}

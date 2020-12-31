package com.reviewdekho.productImage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.model.ProductImage;

public interface ProductImageI extends JpaRepository<ProductImage, Integer> {
	public List<ProductImage> findByProduct(Product product);
}

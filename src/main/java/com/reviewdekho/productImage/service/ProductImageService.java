package com.reviewdekho.productImage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.dao.ProductImageDao;
import com.reviewdekho.productImage.model.ProductImage;

@Service
public class ProductImageService {
	private ProductImageDao dao;

	@Autowired
	public ProductImageService( @Qualifier("product_image") ProductImageDao dao ) {
		this.dao = dao;
	}

	public void add( ProductImage image ) {
		dao.add(image);
	}

	public List<ProductImage> get() {
		return dao.get();
	}

	public ProductImage getById( Integer image_id ) {
		return dao.getById(image_id);
	}

	public void update( ProductImage image, Integer image_id ) {
		dao.update(image_id, image);
	}

	public void delete( Integer image_id ) {
		dao.delete(image_id);
	}
	
	public Product getProductById( Integer productId ) {
		return dao.getProductById(productId);
	}
}


package com.reviewdekho.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.product.dao.ProductDao;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.model.SubCategory;

@Service
public class ProductService {
	private ProductDao dao;

	@Autowired
	public ProductService( @Qualifier("product") ProductDao dao ) {
		this.dao = dao;
	}

	public void add( Product product ) {
		dao.add(product);
	}

	public List<Product> get() {
		return dao.get();
	}

	public List<Product> getBySubCategory( SubCategory subCategory ){
		return dao.getBySubCategory(subCategory);
	}
	
	public Product getById( Integer product_id ) {
		return dao.getById(product_id);
	}

	public void update( Product product, Integer product_id ) {
		dao.update(product, product_id);
	}

	public void delete( Integer product_id ) {
		dao.delete(product_id);
	}
	
	public SubCategory getSubCategoryById( Integer subCategoryId ) {
		return dao.getSubCategoryById(subCategoryId);
	}
}

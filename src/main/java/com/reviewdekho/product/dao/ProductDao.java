package com.reviewdekho.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.category.dao.CategoryDaoI;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.subcategory.dao.SubCategoryDaoI;
import com.reviewdekho.subcategory.model.SubCategory;

@Repository("product")
public class ProductDao {
	@Autowired
	ProductDaoI productRepo;
	
	@Autowired
	SubCategoryDaoI subCategoryRepo;
	
	@Autowired
	CategoryDaoI cateoryRepo;

	public void add( Product product ) {
		productRepo.save( product );
	}

	public List<Product> get(){
		return productRepo.findAll();
	}

	public Product getById( final Integer product_id ) {
		return productRepo.findById(product_id).orElse(null);
	}
	
	public List<Product> getBySubCategory( SubCategory subCategory ){
		return productRepo.findBySubCategory(subCategory);
	}

	public void update( Product product, Integer product_id ) {
		Product productTo = getById(product_id);
		productTo.setProduct_name(product.getProduct_name());
		productTo.setProduct_desc( product.getProduct_desc() );
		productTo.setProduct_price( product.getProduct_price() );
//		productTo.setSubCategory( product.getSubCategory() );
		productRepo.save(productTo);
	}

	public void delete( Integer product_id ) {
		productRepo.deleteById(product_id);
	}
	
	public SubCategory getSubCategoryById( Integer subCategoryId ) {
		
		SubCategory subCategory = subCategoryRepo.findById(subCategoryId).orElse(null);
		subCategory.setCategory( cateoryRepo.findById( subCategory.getCategory().getCategory_id() ).orElse(null) );
		return subCategory;
	}
}


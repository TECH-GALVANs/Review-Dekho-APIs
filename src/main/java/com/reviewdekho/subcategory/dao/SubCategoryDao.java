package com.reviewdekho.subcategory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.category.dao.CategoryDao;
import com.reviewdekho.category.dao.CategoryDaoI;
import com.reviewdekho.category.model.Category;
import com.reviewdekho.subcategory.model.SubCategory;

@Repository("subcategory")
public class SubCategoryDao {
	@Autowired
	CategoryDaoI categoryRepo;
	
	@Autowired
	SubCategoryDaoI subCategoryRepo;
	
	public SubCategoryDao() {
		System.out.println("From Sub category repo");
		System.out.println("From Sub category repo");
	}
	
	public void add( SubCategory subcategory ) {
		subCategoryRepo.save( subcategory );
	}

	public List<SubCategory> get(){
		return subCategoryRepo.findAll();
	}

	public List<SubCategory> getByCategory( Category category ){
		return subCategoryRepo.findByCategory(category);
	}
	
	public SubCategory getById( final Integer sub_category_id ) {
		return subCategoryRepo.findById(sub_category_id).orElse(null);
	}

	public void update( SubCategory subcategory, Integer sub_category_id ) {
		SubCategory subcategoryTo = getById(sub_category_id);
		subcategoryTo.setSub_category_name(subcategory.getSub_category_name());
//		subcategoryTo.setCategory(subcategory.getCategory());
		subCategoryRepo.save(subcategoryTo);
	}

	public void delete( Integer sub_category_id ) {
		subCategoryRepo.deleteById(sub_category_id);
	}
	
	public Category getByIdCategory( final Integer categoryId ) {
		System.out.println(categoryRepo.findById( categoryId ).orElse(null));
		return categoryRepo.findById( categoryId ).orElse(null);
	}
}




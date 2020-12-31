package com.reviewdekho.category.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.category.model.Category;

@Repository("category")
public class CategoryDao {
	@Autowired
	CategoryDaoI categoryRepo;
	
	public void add( Category category ) {
		categoryRepo.save( category );
	}
	
	public List<Category> get(){
		return categoryRepo.findAll();
	}
	
	public Category getById( final Integer category_id ) {
		return categoryRepo.findById(category_id).orElse(null);
	}
	
	public void update( Category category, Integer category_id ) {
		Category categoryTo = getById(category_id);
		categoryTo.setCategory_name(category.getCategory_name());
		
		categoryRepo.save(categoryTo);
	}
	
	public void delete( Integer category_id ) {
		categoryRepo.deleteById(category_id);
	}
}

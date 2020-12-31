package com.reviewdekho.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reviewdekho.category.model.Category;

@Repository
public interface CategoryDaoI extends JpaRepository<Category, Integer> {

//	public void add( Category category );
//	
//	public List<Category> get();
//	
//	public Category getById();
//	
//	public void update( Category category, Integer categoey_id );
//	
//	public void delete( Integer categoey_id );
}

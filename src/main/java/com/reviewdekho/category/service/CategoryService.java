package com.reviewdekho.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.category.dao.CategoryDao;
import com.reviewdekho.category.model.Category;

@Service
public class CategoryService {
	private CategoryDao dao;
	
	@Autowired
	public CategoryService( @Qualifier("category") CategoryDao dao ) {
		this.dao = dao;
	}
	
	public void add( Category category ) {
		dao.add(category);
	}
	
	public List<Category> get() {
		return dao.get();
	}
	
	public Category getById( Integer category_id ) {
		return dao.getById(category_id);
	}
	
	public void update( Category category, Integer category_id ) { 
		dao.update(category, category_id);
	}
	
	public void delete( Integer category_id ) {
		dao.delete(category_id);
	}
}

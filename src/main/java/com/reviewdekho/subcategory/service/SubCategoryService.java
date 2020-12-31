package com.reviewdekho.subcategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.category.model.Category;
import com.reviewdekho.subcategory.dao.SubCategoryDao;
import com.reviewdekho.subcategory.model.SubCategory;

@Service
public class SubCategoryService {
	private SubCategoryDao dao;

	@Autowired
	public SubCategoryService( @Qualifier("subcategory") SubCategoryDao dao ) {
		this.dao = dao;
	}

	public void add( SubCategory subcategory ) {
		dao.add(subcategory);
	}

	public List<SubCategory> get() {
		return dao.get();
	}

	public List<SubCategory> getByCategory( Category category ){
		return dao.getByCategory(category);
	}
	
	public SubCategory getById( Integer sub_category_id ) {
		return dao.getById(sub_category_id);
	}

	public void update( SubCategory subcategory, Integer sub_category_id ) {
		dao.update(subcategory, sub_category_id);
	}

	public void delete( Integer sub_category_id ) {
		dao.delete(sub_category_id);
	}
	
	public Category categoryById( Integer category_id ) {
		return dao.getByIdCategory(category_id);
	}
}

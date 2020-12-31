package com.reviewdekho.subcategory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reviewdekho.category.model.Category;
import com.reviewdekho.subcategory.model.SubCategory;

@Repository
public interface SubCategoryDaoI extends JpaRepository<SubCategory, Integer> {
	List<SubCategory> findByCategory(Category category);
}

package com.reviewdekho.subcategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.category.controller.CategoryController;
import com.reviewdekho.category.dao.CategoryDao;
import com.reviewdekho.category.dao.CategoryDaoI;
import com.reviewdekho.category.model.Category;
import com.reviewdekho.category.service.CategoryService;
import com.reviewdekho.subcategory.model.SubCategory;
import com.reviewdekho.subcategory.service.SubCategoryService;

@RequestMapping("api/sub-category")
@RestController
public class SubCategoryController {
	private SubCategoryService subcategoryService;
	
	@Autowired
	public SubCategoryController( SubCategoryService subcategoryService ) {
		System.out.println("From Controller-constructor");
		this.subcategoryService = subcategoryService;
	}

	@PostMapping
	public void add( @RequestBody SubCategory subcategory ) {
		subcategory.setCategory( subcategoryService.categoryById(subcategory.getCategory().getCategory_id()) );
		subcategoryService.add(subcategory);
	}

	@GetMapping
	public List<SubCategory> get(){
		System.out.println("From Controller-get");
		return subcategoryService.get();
	}

	@GetMapping(path="{id}")
	public SubCategory getById( @PathVariable("id") Integer sub_category_id ) {
		System.out.println("From Controller-get-id"+sub_category_id);
		return subcategoryService.getById(sub_category_id);
	}
	
	@GetMapping(path="/category/{id}")
	public List<SubCategory> getByCategory( @PathVariable("id") Integer category_id ) {
		System.out.println("From Controller-get-id"+category_id);
		Category category = subcategoryService.categoryById(category_id);
		return subcategoryService.getByCategory(category);
	}

	@PutMapping(path="{id}")
	public void update( @RequestBody SubCategory subcategory, @PathVariable("id") Integer sub_category_id ) {
//		subcategory.setCategory( subcategoryService.categoryById(subcategory.getCategory().getCategory_id()) );
		System.out.println("From Controller-update");
		subcategoryService.update(subcategory, sub_category_id);
	}

	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer sub_category_id ) {
		System.out.println("From Controller-delete");
		subcategoryService.delete(sub_category_id);
	}
}

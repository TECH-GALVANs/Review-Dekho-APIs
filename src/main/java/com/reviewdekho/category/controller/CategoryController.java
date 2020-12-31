package com.reviewdekho.category.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.category.model.Category;
import com.reviewdekho.category.service.CategoryService;

@RequestMapping("api/category")
@RestController
public class CategoryController {
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController( CategoryService categoryService ) {
		System.out.println("From Controller-constructor");
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public void add( @RequestBody Category category ) {
		System.out.println("From Controller-add");
		categoryService.add(category);
	}
	
	@GetMapping
	public List<Category> get(){
		System.out.println("From Controller-get");
		return categoryService.get();
	}
	
	@GetMapping(path="{id}")
	public Category getById( @PathVariable("id") Integer category_id ) {
		System.out.println("From Controller-get-id"+category_id);
		return categoryService.getById(category_id);
	}
	
	@PutMapping(path="{id}")
	public void update( @RequestBody Category category, @PathVariable("id") Integer category_id ) {
		System.out.println("From Controller-update");
		categoryService.update(category, category_id);
	}
	
	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer category_id ) {
		System.out.println("From Controller-delete");
		categoryService.delete(category_id);
	}
}

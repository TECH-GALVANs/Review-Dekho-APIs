package com.reviewdekho.product.controller;

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

import com.reviewdekho.product.model.Product;
import com.reviewdekho.product.service.ProductService;

@RequestMapping("api/product")
@RestController
public class ProductController {
	private ProductService productService;

	@Autowired
	public ProductController( ProductService productService ) {
		System.out.println("From Controller-constructor");
		this.productService = productService;
	}

	@PostMapping
	public void add( @RequestBody Product product ) {
		System.out.println("From Controller-add");
		product.setSubCategory( productService.getSubCategoryById( product.getSubCategory().getSub_category_id() ) );
		productService.add(product);
	}

	@GetMapping
	public List<Product> get(){
		System.out.println("From Controller-get");
		return productService.get();
	}

	@GetMapping(path="{id}")
	public Product getById( @PathVariable("id") Integer product_id ) {
		System.out.println("From Controller-get-id"+product_id);
		return productService.getById(product_id);
	}
	
	@GetMapping(path="/sub_category/{id}")
	public List<Product> getBySubCategory( @PathVariable("id") Integer subCategoryid ) {
		System.out.println("From Controller-get-id"+subCategoryid);
		return productService.getBySubCategory( productService.getSubCategoryById( subCategoryid ) );
	}

	@PutMapping(path="{id}")
	public void update( @RequestBody Product product, @PathVariable("id") Integer product_id ) {
		System.out.println("From Controller-update");
		productService.update(product, product_id);
	}

	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer product_id ) {
		System.out.println("From Controller-delete");
		productService.delete(product_id);
	}
}


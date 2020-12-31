package com.reviewdekho.productImage.controller;

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

import com.reviewdekho.productImage.model.ProductImage;
import com.reviewdekho.productImage.service.ProductImageService;

@RestController
@RequestMapping("api/image")
public class ProductImageController {
	private ProductImageService productImageService;

	@Autowired
	public ProductImageController( ProductImageService productImageService ) {
		System.out.println("From Controller-constructor");
		this.productImageService = productImageService;
	}

	@PostMapping
	public void add( @RequestBody ProductImage product_image ) {
		product_image.setProduct( productImageService.getProductById( product_image.getProduct().getProduct_id() ) );
		System.out.println("From Controller-add");
		productImageService.add(product_image);
	}

	@GetMapping
	public List<ProductImage> get(){
		System.out.println("From Controller-get");
		return productImageService.get();
	}

	@GetMapping(path="{id}")
	public ProductImage getById( @PathVariable("id") Integer product_image_id ) {
		System.out.println("From Controller-get-id"+product_image_id);
		return productImageService.getById(product_image_id);
	}

	@PutMapping(path="{id}")
	public void update( @RequestBody ProductImage product_image, @PathVariable("id") Integer product_image_id ) {
		product_image.setProduct( productImageService.getProductById( product_image.getProduct().getProduct_id() ) );
		System.out.println("From Controller-update"+product_image.getProduct().getProduct_id());
		productImageService.update(product_image, product_image_id);
	}

	@DeleteMapping(path="{id}")
	public void delete( @PathVariable("id") Integer product_image_id ) {
		System.out.println("From Controller-delete");
		productImageService.delete(product_image_id);
	}
}


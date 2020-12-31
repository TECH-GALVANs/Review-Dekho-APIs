package com.reviewdekho.productImage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.product.dao.ProductDaoI;
import com.reviewdekho.product.model.Product;
import com.reviewdekho.productImage.model.ProductImage;

@Repository( "product_image" )
public class ProductImageDao {
	@Autowired
	ProductImageI imageRepo;
	
	@Autowired
	ProductDaoI productRepo;
	
	public void add( ProductImage image ) {
		imageRepo.save( image );
	}
	
	public List< ProductImage > get() {
		return imageRepo.findAll();
	}
	
	public ProductImage getByProduct( Product product ) {
		var list = imageRepo.findByProduct(product);
		return list.get(0);
	}
	
	public ProductImage getById( Integer imageId ) {
		return imageRepo.findById( imageId ).orElse(null);
	}
	
	public void update( Integer imageId, ProductImage image ) {
		ProductImage imageTo = getById(imageId);
		imageTo.setImage(image.getImage());
		imageTo.setProduct( image.getProduct() );
		imageRepo.save(imageTo);
	}
	
	public void delete( Integer imageId ) {
		imageRepo.deleteById( imageId );
	}
	
	public Product getProductById( Integer productId ) {
		return productRepo.findById( productId ).orElse(null);
	}
}

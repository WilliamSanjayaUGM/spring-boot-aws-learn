package com.learn.product_service.mapper;

import org.springframework.stereotype.Service;

import com.learn.product_service.entity.Product;
import com.learn.product_service.model.ProductNewRequestDto;

@Service
public class ProductMapper {
	
	public Product productNewDtoToProductEntity(ProductNewRequestDto productNewRequest) {
		return Product.builder()
				.sku(productNewRequest.getSku())
				.productName(productNewRequest.getProductName())
				.productCategory(productNewRequest.getProductCategory())
				.qty(productNewRequest.getQty())
				.price(productNewRequest.getPrice())
				.fromApproval(productNewRequest.isFromApproval())
				.build();
	}
}

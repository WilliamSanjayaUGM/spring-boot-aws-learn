package com.learn.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.product_service.aws.ProductSnsService;
import com.learn.product_service.entity.Product;
import com.learn.product_service.mapper.ProductMapper;
import com.learn.product_service.model.ProductNewRequestDto;
import com.learn.product_service.model.ProductNewResponseDto;
import com.learn.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	private final ProductSnsService productSnsService;
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public ProductNewResponseDto saveNewProduct(ProductNewRequestDto productNewRequestDto) {
		Optional<Product> productOpt = productRepository.findBySku(productNewRequestDto.getSku());
		
		if(!productOpt.isEmpty()) {
			throw new RuntimeException("Product with sku is already saved");
		}
		
		try {
			Product product = productRepository.save(
					productMapper.productNewDtoToProductEntity(productNewRequestDto));
			
			productSnsService.publishToSns(product);
			
			return ProductNewResponseDto.builder()
					.sku(product.getSku())
					.productId(product.getId())
					.build();
		}catch (Exception e) {
			log.error("Error when saving with message {}", e.getMessage(), e);
			throw new RuntimeException("Error when saving ");
		}
		
	}
	
	public Product findBySku(String sku) {
		return productRepository.findBySku(sku).orElseThrow(
				() -> new RuntimeException("Product with sku "+ sku +"is not found !")
			);
	}
}

package com.learn.product_service.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductNewResponseDto {
	
	private UUID productId;
	private String sku;
}

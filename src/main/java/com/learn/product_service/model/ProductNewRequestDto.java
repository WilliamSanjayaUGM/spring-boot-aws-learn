package com.learn.product_service.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductNewRequestDto {
	
	private String sku;
	private String productName;
	private String productCategory;
	private int qty;
	private BigDecimal price;
	private boolean fromApproval = false;
}

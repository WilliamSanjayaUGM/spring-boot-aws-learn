package com.learn.product_service.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductNewRequestDto {
	
	private String sku;
	private String productName;
	private String productCategory;
	private int qty;
	private BigDecimal price;
	private boolean fromApproval = false;
}

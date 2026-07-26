package com.learn.product_service.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_product")
@Entity
@Getter
@Setter
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "sku", unique = true, nullable = false)
	private String sku;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "product_category", nullable = false)
	private String productCategory;
	
	@Column(name = "qty")
	private int qty;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "from_approval")
	private boolean fromApproval;
	
}

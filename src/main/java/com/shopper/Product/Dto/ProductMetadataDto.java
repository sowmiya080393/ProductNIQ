package com.shopper.Product.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductMetadataDto {

	private String productId;
	
	private String category;
	
	private String brand;

}

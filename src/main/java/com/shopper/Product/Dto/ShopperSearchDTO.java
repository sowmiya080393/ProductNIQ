package com.shopper.Product.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class ShopperSearchDTO {

	
	@NotBlank
	private String shopperId;
	
	private String category;
	
	private String brand;
	
	@Max(value=100)
	private Integer Limit;
	
}

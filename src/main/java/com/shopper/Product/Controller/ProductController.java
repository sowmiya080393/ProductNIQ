package com.shopper.Product.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopper.Product.Dto.ShopperSearchDTO;
import com.shopper.Product.Entity.Shopper;
import com.shopper.Product.Service.ShopperService;

@RestController("/ecom")
public class ProductController {

	@Autowired
	private ShopperService shopperService;
	
	@PostMapping("/products")
	public Page<Shopper> getProductsByShopper(@RequestBody @Valid ShopperSearchDTO shopperFilter){
		Page<Shopper> shopper = shopperService.getProductsByShopper(shopperFilter);
		return shopper;
		
	}
}

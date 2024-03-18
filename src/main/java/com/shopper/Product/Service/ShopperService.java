package com.shopper.Product.Service;

import org.springframework.data.domain.Page;

import com.shopper.Product.Dto.ShopperSearchDTO;
import com.shopper.Product.Entity.Shopper;

public interface ShopperService {

	 Page<Shopper> getProductsByShopper(ShopperSearchDTO shopper);
}

package com.shopper.Product.Service;

import java.util.List;

import com.shopper.Product.Dto.ProductsDTO;
import com.shopper.Product.Dto.ShopperSearchDTO;

public interface ShopperService {

	 List<ProductsDTO> getProductsByShopper(ShopperSearchDTO shopper);
}

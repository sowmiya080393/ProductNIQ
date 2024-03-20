package com.shopper.Product.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Predicates;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shopper.Product.Dto.Product;
import com.shopper.Product.Dto.ProductsDTO;
import com.shopper.Product.Dto.ShopperSearchDTO;
import com.shopper.Product.Entity.ProductMetadata;
import com.shopper.Product.Entity.Shelf;
import com.shopper.Product.Entity.Shopper;
import com.shopper.Product.Repository.ShopperRepository;
import com.shopper.Product.Service.ShopperService;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;

@Service
public class ShopperServiceImpl implements ShopperService {

	@Autowired
	private ShopperRepository shopperRepository;

	@Override
	public List<ProductsDTO> getProductsByShopper(ShopperSearchDTO params) {
		
		List<ProductsDTO> productsList = new ArrayList<ProductsDTO>();
		
		Specification<Shopper> spec = (root, query, criteriaBuilder) -> {
			Join<Shopper, Shelf> shelfJoin = root.join("shelf");
			Join<Shelf, ProductMetadata> productJoin = shelfJoin.join("product");
			List<Predicate> predicates = new ArrayList<Predicate>();
			Predicate shopIdPredicate = criteriaBuilder.equal(root.get("shopperId"), params.getShopperId());
			predicates.add(shopIdPredicate);
			if(Strings.isNotBlank(params.getBrand())) {
			Predicate brandPredicate = criteriaBuilder.equal(productJoin.get("brand"), params.getBrand());
			predicates.add(brandPredicate);
			}
			if(Strings.isNotBlank(params.getCategory())) {
			Predicate categoryPredicate = criteriaBuilder.equal(productJoin.get("category"), params.getCategory());
			predicates.add(categoryPredicate);
			}
			return criteriaBuilder.and( predicates.toArray(new Predicate[predicates.size()]));
		};
		Page<Shopper> shopperDetails=  shopperRepository.findAll(spec,PageRequest.of(0, 10));
		shopperDetails.forEach(details ->{
			for (Shelf shelfs : details.getShelf()) {
				List<Product> products = Arrays.asList(Product.builder().productId(shelfs.getProduct().getId()).brand(shelfs.getProduct().getBrand())
						.category(shelfs.getProduct().getCategory()).build());
				ProductsDTO product = ProductsDTO.builder().product(products).shopperId(details.getShopperId()).build();
				productsList.add(product);
			}
			
		});
		return productsList;

	}
}

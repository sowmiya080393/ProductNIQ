package com.shopper.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shopper.Product.Entity.Shopper;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper,String>,JpaSpecificationExecutor<Shopper>{
	
	
	//@Query(value = "SELECT *  FROM shopper s JOIN shelf f ON (s.shopper_id = f.shopper_id) JOIN  product_metadata pm ON (f.product_id = pm.product_id) WHERE s.shopper_id =?1 and pm.category like ?2 and pm.brand like ?3 limit ?4" , nativeQuery = true)
	//List<Object> getProductsByShopper(String shopper_id, String category, String brand, int limit);

}

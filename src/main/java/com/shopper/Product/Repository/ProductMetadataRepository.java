package com.shopper.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopper.Product.Entity.ProductMetadata;

@Repository
public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, String>{



}

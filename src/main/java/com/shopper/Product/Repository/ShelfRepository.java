package com.shopper.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopper.Product.Entity.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, String > {

}

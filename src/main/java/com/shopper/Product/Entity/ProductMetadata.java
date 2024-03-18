package com.shopper.Product.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Table(name = "product_metadata")
public class ProductMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="product_Id")
	private String id;
	
	@Column(name ="category")
	private String category;
	
	@Column(name ="brand")
	private String brand;
	
	@OneToOne(mappedBy = "product", fetch=FetchType.LAZY)
    private Shelf shelf;
}

package com.shopper.Product.Entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "shelf")
public class Shelf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shelf_Id")
	private String shelfId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_Id", referencedColumnName = "product_Id")
	private ProductMetadata product;

	@Column(name = "relevancy_score")
	private String relevancyScore;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shopper_Id", referencedColumnName = "shopper_Id")
	private Shopper shopper;

}

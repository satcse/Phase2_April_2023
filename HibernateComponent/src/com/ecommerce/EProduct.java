package com.ecommerce;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class EProduct {

	private long ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	private ProductParts parts; // EProduct has a ProductPart - Composition(Object Oriented Concepts).

	public EProduct() {
	}

	public EProduct(long iD, String name, BigDecimal price, Date dateAdded, ProductParts parts) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.parts = parts;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public ProductParts getParts() {
		return parts;
	}

	public void setParts(ProductParts parts) {
		this.parts = parts;
	}

}

package com.ecommerce.entity;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "B2C_CLR")
public class Color {
	@Id
	private Integer id;
	private String name;
	private String code;

	//@JsonIgnoreProperties("color")
	@JsonManagedReference
	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	private Set<Product> products;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Product> getProducts() {
		return products;
	}

}

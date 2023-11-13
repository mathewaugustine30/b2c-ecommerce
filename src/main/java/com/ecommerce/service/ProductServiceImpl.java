package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

enum GroupBy {

	BRAND("brand"), COLOR("color"), SIZE("size");
	String value;

	GroupBy(String name) {
		value = name;
	}

	String getValue() {
		return value;
	}
}

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProducts(String groupByValue, String actualvalue) {
		GroupBy groupBy = GroupBy.valueOf(groupByValue.toUpperCase());
		List<Product> byBrandId =null;
				switch (groupBy) {
		case BRAND:

			byBrandId = productRepository.findByBrandId(Integer.valueOf(actualvalue)).orElseThrow(() -> new CityNotFoundException(actualvalue));
		case COLOR:
			byBrandId = productRepository.findByColorId(Integer.valueOf(actualvalue)).orElseThrow(() -> new CityNotFoundException(actualvalue));

		case SIZE:
			byBrandId = productRepository.findBySize(actualvalue).orElseThrow(() -> new CityNotFoundException(actualvalue));

		default:
			byBrandId = null;

			return byBrandId;
		}
	}

}

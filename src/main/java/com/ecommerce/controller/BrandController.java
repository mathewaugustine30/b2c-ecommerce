package com.ecommerce.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Brand;
import com.ecommerce.service.BrandService;

@RestController
@RequestMapping("/api/brands")
/*@Tag(name = "Plant", description = "the Plant Api")*/
public class BrandController {
	@Autowired
	BrandService brandService;

	@GetMapping(produces="application/json")
/*	@Operation(
			summary = "Fetch all plants",
			description = "fetches all plant entities and their data from data source")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation")
	})*/
	public ResponseEntity<List<Brand>> findAll() {
		List<Brand> list = brandService.findAll();

		return ResponseEntity.ok(list);
	}
}
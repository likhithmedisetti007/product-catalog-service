package com.likhith.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.likhith.catalog.dto.ProductCatalogResponse;
import com.likhith.catalog.service.ProductService;

@RestController
@RequestMapping("/product-catalog")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductCatalogResponse>> getAllProducts() {
		List<ProductCatalogResponse> responseList = service.getAllProducts();
		if (CollectionUtils.isEmpty(responseList)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
		} else {
			return ResponseEntity.ok().body(responseList);
		}
	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductCatalogResponse> getProduct(@PathVariable("id") String id) {
		ProductCatalogResponse response = service.getProduct(id);
		if (ObjectUtils.isEmpty(response)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
		} else {
			return ResponseEntity.ok().body(response);
		}
	}

}
package com.likhith.catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.likhith.catalog.dto.ProductCatalogResponse;

@Service
public interface ProductService {

	List<ProductCatalogResponse> getAllProducts();

	ProductCatalogResponse getProduct(String id);

}
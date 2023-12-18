package com.likhith.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.likhith.catalog.document.Product;
import com.likhith.catalog.dto.ProductCatalogResponse;
import com.likhith.catalog.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductCatalogResponse> getAllProducts() {

		List<ProductCatalogResponse> productCatalogResponseList = new ArrayList<>();
		List<Product> products = productRepository.findAll();

		if (!CollectionUtils.isEmpty(products)) {
			productCatalogResponseList = products.stream().map(product -> {
				ProductCatalogResponse productCatalogResponse = new ProductCatalogResponse();
				BeanUtils.copyProperties(product, productCatalogResponse);
				return productCatalogResponse;
			}).collect(Collectors.toList());
		}

		return productCatalogResponseList;

	}

	@Override
	public ProductCatalogResponse getProduct(String id) {

		ProductCatalogResponse productCatalogResponse = new ProductCatalogResponse();
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			BeanUtils.copyProperties(product.get(), productCatalogResponse);
			return productCatalogResponse;
		} else {
			return null;
		}
	}

}
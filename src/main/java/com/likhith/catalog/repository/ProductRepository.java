package com.likhith.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.likhith.catalog.document.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
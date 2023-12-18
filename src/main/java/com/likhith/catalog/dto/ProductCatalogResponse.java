package com.likhith.catalog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCatalogResponse {

	private String id;
	private String name;
	private String price;
	private String description;

}
package com.tantuart.mapper;

import java.util.List;

import com.tantuart.dto.ProductDto;
import com.tantuart.dto.ProductFieldDto;
import com.tantuart.entity.Product;

public class ProductMapper {
	
	public static ProductDto convertToDto(Product product) {
	    ProductDto dto = new ProductDto();
	    dto.setTitle(product.getTitle());
	    dto.setDescription(product.getDescription());
	    dto.setPrice(product.getPrice());
	    dto.setImageUrl(product.getImageUrl());
	    dto.setSize(product.getSize());
	    dto.setAvailable(product.isAvailable());

	    List<ProductFieldDto> fields = product.getFields().stream().map(field -> {
	        ProductFieldDto fieldDto = new ProductFieldDto();
	        fieldDto.setLabel(field.getLabel());
	        fieldDto.setType(field.getType());
	        fieldDto.setRequired(field.isRequired());
	        return fieldDto;
	    }).toList();

	    dto.setFields(fields);
	    return dto;
	}


}

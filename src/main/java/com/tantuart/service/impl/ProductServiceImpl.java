package com.tantuart.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tantuart.entity.Category;
import com.tantuart.entity.Product;
import com.tantuart.entity.ProductField;
import com.tantuart.repository.CategoryRepository;
import com.tantuart.repository.ProductFieldsRepository;
import com.tantuart.repository.ProductRepository;
import com.tantuart.service.ProductService;
import com.tantuart.dto.ProductDto;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductFieldsRepository productFieldRepository;

    
    @Override
    public Product createProduct(Long categoryId, ProductDto productDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Convert DTO to entity (Product)
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setSize(productDto.getSize());
        product.setImageUrl(productDto.getImageUrl());
        product.setAvailable(productDto.isAvailable());
        product.setCategory(category);

        // Save Product first to get ID
        Product savedProduct = productRepository.save(product);

        // Map and save product fields
        List<ProductField> fields = productDto.getFields().stream().map(dto -> {
            ProductField field = new ProductField();
            field.setLabel(dto.getLabel());
            field.setType(dto.getType());
            field.setRequired(dto.isRequired());
            field.setProduct(savedProduct); // Foreign Key set here
            return field;
        }).toList();

        productFieldRepository.saveAll(fields);
        savedProduct.setFields(fields);

        return savedProduct;
    }

    



	@Override
	public Product updateProduct(Long productId, Product updatedProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	    public List<Product> getProductsByCategory(Long categoryId) {
	        return productRepository.findByCategoryId(categoryId);
	    }

}


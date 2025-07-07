package com.tantuart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tantuart.dto.CategoryDto;
import com.tantuart.entity.Category;
import com.tantuart.entity.Product;
import com.tantuart.service.CategoryService;
import com.tantuart.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class HomeController {
	

	private final ProductService productService;

	    private final CategoryService categoryService;

	    @GetMapping("/categories")
	    public ResponseEntity<List<CategoryDto>> getAllCategories() {
	        List<CategoryDto> categories = categoryService.getAllCategories();
	        return ResponseEntity.ok(categories);
	    }
	    
	    @GetMapping("/category/{categoryId}")
	    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
	        List<Product> products = productService.getProductsByCategory(categoryId);
	        return ResponseEntity.ok(products);
	    }
}

package com.tantuart.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tantuart.dto.CategoryDto;
import com.tantuart.dto.ProductDto;
import com.tantuart.entity.Category;
import com.tantuart.entity.Product;
import com.tantuart.mapper.ProductMapper;
import com.tantuart.service.CategoryService;
import com.tantuart.service.ProductService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;

    // ✅ Create Category
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    // ✅ Update Category
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    // ✅ Delete Category
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Get All Categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // ✅ Get Single Category
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    
    
    @PostMapping("/products/category/{categoryId}")
    public ResponseEntity<ProductDto> createProduct(
            @PathVariable Long categoryId,
            @RequestBody ProductDto productDto) {

        Product saved = productService.createProduct(categoryId, productDto);
        ProductDto responseDto =ProductMapper.convertToDto(saved);
        return ResponseEntity.ok(responseDto);
    }
    
    
  
    


}


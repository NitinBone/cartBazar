package com.tantuart.service;

import java.util.List;
import com.tantuart.dto.ProductDto;


import com.tantuart.entity.Product;

public interface ProductService {

	Product createProduct(Long categoryId, ProductDto productDto);

    Product updateProduct(Long productId, Product updatedProduct);

    void deleteProduct(Long productId);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    List<Product> getProductsByCategory(Long categoryId);
    

}


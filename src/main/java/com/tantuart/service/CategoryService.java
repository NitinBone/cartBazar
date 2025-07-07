package com.tantuart.service;

import java.util.List;

import com.tantuart.dto.CategoryDto;
import com.tantuart.entity.Category;

public interface CategoryService {
	
	 Category createCategory(Category category);

	    Category updateCategory(Long id, Category category);

	    void deleteCategory(Long id);

	    Category getCategoryById(Long id);

	    List<CategoryDto> getAllCategories();

}

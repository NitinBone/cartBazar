package com.tantuart.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String size;
    private boolean available;
    private List<ProductFieldDto> fields;
}


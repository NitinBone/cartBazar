package com.tantuart.dto;

import lombok.Data;

@Data
public class ProductFieldDto {
    private String label;
    private String type;
    private boolean required;
}

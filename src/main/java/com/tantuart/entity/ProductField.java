package com.tantuart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productfields")
@Data
public class ProductField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;     // e.g., Name, Date of Birth
    private String type;      // text, number, date, etc.
    private boolean required;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    
    
}

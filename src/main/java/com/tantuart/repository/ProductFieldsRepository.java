package com.tantuart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tantuart.entity.Product;
import com.tantuart.entity.ProductField;

@Repository
public interface ProductFieldsRepository extends JpaRepository<ProductField, Long> {
}

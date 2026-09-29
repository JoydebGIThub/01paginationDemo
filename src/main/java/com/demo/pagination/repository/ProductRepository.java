package com.demo.pagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pagination.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  // Page: runs an extra COUNT query, so it knows total pages
  Page<Product> findByCategory(String category, Pageable pageable);

  // Slice: no COUNT query, only knows if a next page exists
  Slice<Product> findByPriceGreaterThan(double price, Pageable pageable);
}

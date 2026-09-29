package com.demo.pagination.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.pagination.entity.PageResponse;
import com.demo.pagination.entity.Product;
import com.demo.pagination.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public PageResponse<Product> getAll(int page, int size, String sortBy, String dir) {
    Sort sort = dir.equalsIgnoreCase("desc")
        ? Sort.by(sortBy).descending()
        : Sort.by(sortBy).ascending();
    Pageable pageable = PageRequest.of(page, size, sort);
    return PageResponse.from(productRepository.findAll(pageable));
  }

  public PageResponse<Product> getByCategory(String category, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return PageResponse.from(productRepository.findByCategory(category, pageable));
  }

  public Slice<Product> getExpensive(double minPrice, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return productRepository.findByPriceGreaterThan(minPrice, pageable);
  }

  public Page<Product> getAuto(Pageable pageable) {
    return productRepository.findAll(pageable);
  }
}

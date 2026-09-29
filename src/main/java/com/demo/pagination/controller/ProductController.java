package com.demo.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pagination.entity.PageResponse;
import com.demo.pagination.entity.Product;
import com.demo.pagination.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  // Manual page/size/sort parameters
  @GetMapping
  public PageResponse<Product> getAll(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(defaultValue = "asc") String dir) {
    return service.getAll(page, size, sortBy, dir);
  }

  // Pagination + filter
  @GetMapping("/category/{category}")
  public PageResponse<Product> byCategory(@PathVariable String category, @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    return service.getByCategory(category, page, size);
  }

  // Slice example
  @GetMapping("/slice")
  public Slice<Product> slice(@RequestParam double minPrice, @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    return service.getExpensive(minPrice, page, size);
  }

  // Spring injects Pageable automatically from ?page=&size=&sort=
  @GetMapping("/auto")
  public Page<Product> auto(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
    return service.getAuto(pageable);
  }
}

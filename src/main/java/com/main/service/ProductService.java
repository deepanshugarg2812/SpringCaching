package com.main.service;

import com.main.entity.Product;
import com.main.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    @Cacheable(cacheNames = {"product"}, key = "#id")
    public Product getAllProducts(Long id) {
        System.out.println("Execution started");
        return productRepo.findById(id).get();
    }

    @CachePut(cacheNames = {"product"}, key = "#id")
    public Product updateProduct(Long id, String name) {
        Product product = productRepo.findById(id).get();
        product.setName(name);
        return productRepo.save(product);
    }

    @CacheEvict(cacheNames = {"product"}, key = "#id")
    public boolean deleteProduct(Long id) {
        productRepo.deleteById(id);
        return true;
    }
}

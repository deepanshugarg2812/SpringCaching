package com.main.controller;

import com.main.entity.Product;
import com.main.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getAll/{id}")
    public ResponseEntity<Object> getAllProducts(@PathVariable(name = "id") Long id) {
        return ResponseEntity.accepted().body(productService.getAllProducts(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "name") String name, @PathVariable(name = "id") Long id) {
        return ResponseEntity.accepted().body(productService.updateProduct(id, name));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.accepted().body(productService.deleteProduct(id));
    }
}

package com.mgbt.apirestspringmysql.controller;

import com.mgbt.apirestspringmysql.entity.Product;
import com.mgbt.apirestspringmysql.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products/")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") int id) {
        Product product = productService.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/find/")
    public ResponseEntity<List<Product>> findByCategory(@RequestParam(name = "category") String category) {
        List<Product> products = productService.findProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/post/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        product = productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
        product.setIdProduct(id);
        productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") int id, Product product) {
        product.setIdProduct(id);
        productService.deleteProduct(product);
        return ResponseEntity.ok("Product removed successfully");
    }
}
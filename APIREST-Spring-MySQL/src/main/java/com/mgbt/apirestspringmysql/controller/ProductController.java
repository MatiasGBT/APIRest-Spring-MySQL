package com.mgbt.apirestspringmysql.controller;

import com.mgbt.apirestspringmysql.entity.Product;
import com.mgbt.apirestspringmysql.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products/")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public List<Product> findAllProducts() {
        List<Product> products = productService.findAll();
        return products;
    }

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable(name = "id") int id) {
        Product product = productService.findProduct(id);
        return product;
    }

    @GetMapping("/find/")
    public List<Product> findByCategory(@RequestParam(name = "category") String category) {
        List<Product> products = productService.findProductByCategory(category);
        return products;
    }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product) {
        product = productService.saveProduct(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
        product.setIdProduct(id);
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id, Product product) {
        product.setIdProduct(id);
        productService.deleteProduct(product);
        return "Product removed successfully";
    }
}
package com.mgbt.apirestspringmysql.service;

import com.mgbt.apirestspringmysql.entity.Product;
import java.util.List;

public interface IProductService {
    public List<Product> findAll();

    public Product findProduct(int idProduct);

    public List<Product> findProductByCategory(String category);

    public Product saveProduct(Product product);

    public void deleteProduct(Product product);
}

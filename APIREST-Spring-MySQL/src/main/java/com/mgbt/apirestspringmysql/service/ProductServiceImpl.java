package com.mgbt.apirestspringmysql.service;

import com.mgbt.apirestspringmysql.entity.Product;
import com.mgbt.apirestspringmysql.repository.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProduct(int idProduct) {
        return productDao.findById(idProduct).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByCategory(String category) {
        return productDao.findByCategory(category);
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        productDao.save(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        productDao.delete(product);
    }
}
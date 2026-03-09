package com.billing.billingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.billingsystem.entity.Product;
import com.billing.billingsystem.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}
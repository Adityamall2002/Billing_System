package com.billing.billingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.billingsystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByBarcode(String barcode);

}
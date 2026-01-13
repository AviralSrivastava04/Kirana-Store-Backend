package com.example.kirana.store.service;

import com.example.kirana.store.entity.Product;
import com.example.kirana.store.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

//    public Product addProduct() {
//    }
}

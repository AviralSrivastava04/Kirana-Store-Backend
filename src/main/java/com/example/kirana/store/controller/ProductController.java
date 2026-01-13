package com.example.kirana.store.controller;

import com.example.kirana.store.entity.Product;
import com.example.kirana.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

//    @PostMapping("/addProduct")
//    public ResponseEntity<Product> addProduct(@RequestBody Product product){
//        return ResponseEntity.ok(productService.addProduct());
//    }

}

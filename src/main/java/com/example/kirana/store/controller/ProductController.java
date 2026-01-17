package com.example.kirana.store.controller;

import com.example.kirana.store.dto.inputDto.ProductInputDto;
import com.example.kirana.store.dto.outputDto.ProductOutputDto;
import com.example.kirana.store.entity.Product;
import com.example.kirana.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductOutputDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductOutputDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductInputDto productInputDto){
        return ResponseEntity.ok(productService.addProduct(productInputDto));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductInputDto> updateProduct(@PathVariable Long id, @RequestBody ProductInputDto productInputDto){
        return ResponseEntity.ok(productService.updateProduct(id, productInputDto));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted!!!");
    }
}

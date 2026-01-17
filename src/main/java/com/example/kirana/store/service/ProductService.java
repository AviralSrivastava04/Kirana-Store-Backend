package com.example.kirana.store.service;

import com.example.kirana.store.dto.inputDto.ProductInputDto;
import com.example.kirana.store.dto.outputDto.ProductOutputDto;
import com.example.kirana.store.entity.Product;
import com.example.kirana.store.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<ProductOutputDto> getAllProducts(){
        List<Product> products = productRepo.findAll();
        List<ProductOutputDto> productOutputDtoList = new ArrayList<>();
        for (Product product : products){
            ProductOutputDto productOutputDto = new ProductOutputDto();
            productOutputDto.setProductName(product.getProductName());
            productOutputDto.setProductPrice(product.getProductPrice());
            productOutputDto.setProductDescription(product.getProductDescription());
            productOutputDto.setId(product.getId());
            productOutputDtoList.add(productOutputDto);
        }
        return productOutputDtoList;
    }

    public String addProduct(ProductInputDto productInputDto) {
        Product product = new Product();
        product.setProductName(productInputDto.getProductName());
        product.setProductPrice(productInputDto.getProductPrice());
        product.setProductDescription(productInputDto.getProductDescription());
        productRepo.save(product);

        return "Product Added!!!";
    }

    public ProductInputDto updateProduct(Long id, ProductInputDto productInputDto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found!!!"));
        product.setProductName(productInputDto.getProductName());
        product.setProductPrice(productInputDto.getProductPrice());
        product.setProductDescription(productInputDto.getProductDescription());
        productRepo.save(product);

        return productInputDto;
    }

    public void deleteProduct(Long id) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found!!!"));

        productRepo.delete(existingProduct);
    }

    public ProductOutputDto getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found!!!"));


        ProductOutputDto productOutputDto = new ProductOutputDto();
        productOutputDto.setId(product.getId());
        productOutputDto.setProductPrice(product.getProductPrice());
        productOutputDto.setProductName(product.getProductName());
        productOutputDto.setProductDescription(product.getProductDescription());

        return productOutputDto;
    }
}

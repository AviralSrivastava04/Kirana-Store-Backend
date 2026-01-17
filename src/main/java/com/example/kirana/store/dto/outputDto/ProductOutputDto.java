package com.example.kirana.store.dto.outputDto;

import lombok.Data;

@Data
public class ProductOutputDto {
    private Long id;
    private String productName;
    private Long productPrice;
    private String productDescription;
}

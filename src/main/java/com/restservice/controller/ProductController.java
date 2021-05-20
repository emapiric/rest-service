package com.restservice.controller;

import com.restservice.entity.Product;
import com.restservice.dto.ProductDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @PostMapping
    public List<Product> product(@RequestBody List<ProductDTO> products) {
        return products
                .stream()
                .map(productDTO -> new Product(productDTO.getIssuerName(),productDTO.getIsin(),productDTO.getUnderlyingStockName(),productDTO.getYield()))
                .sorted(Comparator.comparing(Product::getYield).reversed())
                .collect(Collectors.toList());
    }
}

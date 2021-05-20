package com.restservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String issuerName;
    private String isin;
    private String underlyingStockName;
    private double yield;
}

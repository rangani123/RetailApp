package com.sntechnologies.retailapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Product Name can not be null")
    private String productname;

    @Min(value = 10, message = "price can not be empty")
    private float price;

    @Min(value = 3, message = "Product Quantity should start with 3")
    @Max(5)
    private int productqty;



}
package com.sntechnologies.retailapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private  long supplierId;
    @NotNull(message = "Supplier Name can not be empty")
private String supplierName;
    @NotNull(message = "Supplier Location  can not be empty")
    private String supplierLocation;

}

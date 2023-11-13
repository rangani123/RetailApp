package com.sntechnologies.retailapp.service;

import com.sntechnologies.retailapp.entity.Product;

import java.util.List;

public interface ProductService {
public Product addProduct(Product product);

 public    Product getProduct(Long productid);
public List<Product>getListofProduct();
public Product updateProduct(Product product);

public List<Product>deleteProduct(long productid);

public List<Product>deleteAllProduct();
}

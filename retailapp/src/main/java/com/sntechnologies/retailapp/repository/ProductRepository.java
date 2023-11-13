package com.sntechnologies.retailapp.repository;

import com.sntechnologies.retailapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

}

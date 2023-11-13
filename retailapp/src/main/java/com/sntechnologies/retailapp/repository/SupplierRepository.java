package com.sntechnologies.retailapp.repository;

import com.sntechnologies.retailapp.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long>
{
}

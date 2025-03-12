package com.CRUD.First.Crud.repository;

import com.CRUD.First.Crud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

}

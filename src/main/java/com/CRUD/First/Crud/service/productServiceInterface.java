package com.CRUD.First.Crud.service;

import com.CRUD.First.Crud.entity.ProductEntity;
import java.util.*;
public interface productServiceInterface {
ProductEntity createProduct(ProductEntity product);
ProductEntity updateProductById(Integer productId , ProductEntity product);
List<ProductEntity> getAllProducts();
ProductEntity getProductById(Integer productId);
boolean deleteProductById(Integer productId);
}

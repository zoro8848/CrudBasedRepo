package com.CRUD.First.Crud.service.ProductService;

import com.CRUD.First.Crud.entity.ProductEntity;
import com.CRUD.First.Crud.repository.ProductRepository;
import com.CRUD.First.Crud.service.productServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements productServiceInterface {
    @Autowired
    ProductRepository productRepo;

    public ProductEntity createProduct(ProductEntity product){
        productRepo.save(product);
        return product;
    }

    public ProductEntity updateProductById(Integer productId , ProductEntity product){
        Optional<ProductEntity> singleProduct = productRepo.findById(productId);
        if(singleProduct.isPresent()){
            product.setId(productId);
            productRepo.save(product);
            return product;
        }
        return null;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    public ProductEntity getProductById(Integer productId) {
        Optional<ProductEntity> singleProduct = productRepo.findById(productId);
        if(singleProduct.isPresent()){
            return singleProduct.get();
        }else return null;
    }

    public boolean deleteProductById(Integer productId) {
        Optional<ProductEntity> singleProduct = productRepo.findById(productId);
        if(singleProduct.isPresent()){
            productRepo.deleteById(productId);
            return true;
        }else return false;
    }
}

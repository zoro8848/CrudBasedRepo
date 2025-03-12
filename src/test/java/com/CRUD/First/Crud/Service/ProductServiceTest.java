package com.CRUD.First.Crud.Service;

import com.CRUD.First.Crud.entity.ProductEntity;
import com.CRUD.First.Crud.repository.ProductRepository;
import com.CRUD.First.Crud.service.ProductService.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepo;

    @Test
    @Transactional
    public void createProductTest(){
        ProductEntity newProduct = new ProductEntity("wikibot",120,"bottel");

        productService.createProduct(newProduct);

        Optional<ProductEntity> isProductThere = productRepo.findById(newProduct.getProduct_id());

        Assertions.assertTrue(isProductThere.isPresent());
        Assertions.assertEquals("wikibot" , isProductThere.get().getName());
        Assertions.assertEquals(120 , isProductThere.get().getPrice());
        Assertions.assertEquals("bottel" , isProductThere.get().getCategory());
    }

    @Test
    @Transactional
    public void getAllProductTest(){
        System.out.println("Product repo product" + productRepo.findAll());
        System.out.println("Product service product" + productService.getAllProducts());
        assertEquals(productRepo.findAll() , productService.getAllProducts());
    }

    @Test
    @Transactional
    public void updateProductByIdTest(){
        ProductEntity newProduct = new ProductEntity("mini_val",2000,"vechicle");
        productService.createProduct(newProduct);

        ProductEntity updatedProduct = new ProductEntity("Big_Van",5000,"vechicle");
        productService.updateProductById(newProduct.getProduct_id() , updatedProduct);

        Optional<ProductEntity> isProductThere = productRepo.findById(newProduct.getProduct_id());

        assertTrue(isProductThere.isPresent());
        assertEquals("Big_Van",isProductThere.get().getName());
        assertEquals(5000,isProductThere.get().getPrice());
        assertEquals("vechicle",isProductThere.get().getCategory());
    }

    @Test
    @Transactional
    public void getProductByIdTest(){
        ProductEntity newProduct  = new ProductEntity("led_tv" , 4000,"TV");
        productService.createProduct(newProduct);

        Optional<ProductEntity> isProductThere = productRepo.findById(newProduct.getProduct_id());

        Assertions.assertNotNull(productService.getProductById(newProduct.getProduct_id()));

        Assertions.assertTrue(isProductThere.isPresent());

        Assertions.assertEquals("led_tv" , isProductThere.get().getName());
        Assertions.assertEquals(4000 , isProductThere.get().getPrice());
        Assertions.assertEquals("TV" , isProductThere.get().getCategory());
    }

}

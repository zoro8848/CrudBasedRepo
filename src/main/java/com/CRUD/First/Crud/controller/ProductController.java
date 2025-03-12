package com.CRUD.First.Crud.controller;

import com.CRUD.First.Crud.entity.ApiResponse;
import com.CRUD.First.Crud.entity.ProductEntity;
import com.CRUD.First.Crud.service.ProductService.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Controller
@RequestMapping(path = "/v1/api/product")
public class ProductController {

    @Autowired
    ProductService prdService;

    @PostMapping(path = "/createProduct")
    public  ResponseEntity<ApiResponse<ProductEntity>> createProduct(@Valid @RequestBody ProductEntity product){
       try{
           System.out.println("product found "  + product.toString());
           ProductEntity createdProduct =    prdService.createProduct(product);
           ApiResponse<ProductEntity> resp1 = new ApiResponse<>("Success" , "Product Created Successfully" , createdProduct);
           return new ResponseEntity<>(resp1,HttpStatus.CREATED);
       }catch (Exception e){
           System.out.println("Exception found in productCreation" + e);
           ApiResponse<ProductEntity> errResponse = new ApiResponse<>("failure" , "Something went wrong" , null);
           return new ResponseEntity<>(errResponse , HttpStatus.BAD_REQUEST);
       }
    }

    @PutMapping(path = "/updateProduct/{productId}")
    public ResponseEntity<ApiResponse<ProductEntity>> UpdateProduct(@PathVariable Integer productId , @Valid @RequestBody ProductEntity product){
        ProductEntity updatedProduct = prdService.updateProductById(productId, product);
        if(updatedProduct != null){
            ApiResponse<ProductEntity> successResponse = new ApiResponse<>("Success" , "Product updated successfully" , updatedProduct);
            return new ResponseEntity<>(successResponse , HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "Product Not Found" , null) , HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity<ApiResponse<ProductEntity>>  GetAllProduct(){
        return new ResponseEntity(new ApiResponse("success" , "All Product with us" , prdService.getAllProducts())
                , HttpStatus.OK);
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ApiResponse<?>> GetProductById(@PathVariable Integer productId){
        ProductEntity existedProductOrNot = prdService.getProductById(productId);
        if(existedProductOrNot != null){
            return new ResponseEntity<>(new ApiResponse<>("success" , "found product with productId: " + productId , existedProductOrNot),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "Product Not Found" , null) , HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<ApiResponse<?>> DeleteProductById(@PathVariable Integer productId){
      if(prdService.deleteProductById(productId)){
          return new ResponseEntity<>(new ApiResponse<>("success" , "Product removed from record" , null) , HttpStatus.OK);
      }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "Product Not found" , null) , HttpStatus.NOT_FOUND);
    }

}

package com.CRUD.First.Crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue
    private Integer product_id;
    @NotEmpty (message = "Product Name cannot be empty")
    private String name;
    @NotNull(message = "price is must")
    private Integer price;
    @NotEmpty(message = "Have the category of the product")
    private String category;

    public ProductEntity(String name , Integer price , String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString(){
        return "product Name " + name + "product Category " + category + "product price " ;
    }

    public void setId(Integer id){
        this.product_id = id;
    }

    public ProductEntity(){};

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

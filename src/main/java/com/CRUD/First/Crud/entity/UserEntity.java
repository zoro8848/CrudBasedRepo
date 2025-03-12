package com.CRUD.First.Crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty (message = "Name cannot be empty")
    private String name;
    @NotEmpty (message = "Email is required")
    private String email;

   public UserEntity(String name , String email){
        this.name  = name;
        this.email = email;
    }

    public  UserEntity(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

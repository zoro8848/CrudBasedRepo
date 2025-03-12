package com.CRUD.First.Crud.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// Controller testing ---> web layer testing
    /*
        use @WebMvcTest + MockMvc
     */
    @WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    public void createUserTest(){
    }

}
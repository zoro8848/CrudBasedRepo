package com.CRUD.First.Crud.Service;

import com.CRUD.First.Crud.entity.UserEntity;
import com.CRUD.First.Crud.repository.UserRepository;
import com.CRUD.First.Crud.service.usrService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    /*
    Testing the service layer here

     */
    @Test
    public void createUserTest(){
        UserEntity newUser = new UserEntity("champ" , "cm@gmail.com");

        userService.createUser(newUser);

        Optional<UserEntity> isUserThere = userRepository.findById(newUser.getId());

        Assertions.assertTrue(isUserThere.isPresent());
        Assertions.assertEquals("champ" , isUserThere.get().getName() );
        Assertions.assertEquals("cm@gmail.com",isUserThere.get().getEmail());

    }
    @Test
    public void updateUserTest(){
    /*
        when talking about updation you create first , and then update based on that
     */

//        user creation part
        UserEntity newUser = new UserEntity();
        newUser.setName("anotonio");
        newUser.setEmail("anto@gmail.com");

        userService.createUser(newUser);

//        user updation part
        UserEntity updatedUser = new UserEntity("ana","anto@gmail.com");
        userService.updateUser(newUser.getId(),updatedUser);

        Optional<UserEntity> isUserThere = userRepository.findById(newUser.getId());

        assertTrue(isUserThere.isPresent());
        assertEquals("ana",isUserThere.get().getName());
        assertEquals("anto@gmail.com",isUserThere.get().getEmail());
    }
    @Test
    public void getAllProductsTest(){
        assertEquals(userRepository.findAll() , userService.getAllUser());
}

    @Test
    public void getUserByIdTest(){
    UserEntity newUser = new UserEntity("gojo","goj@gmail.com");
    userService.createUser(newUser);

    assertNotNull(userService.getUserById(newUser.getId()));

    Optional<UserEntity> isUserThere = userRepository.findById(newUser.getId());
    assertTrue(isUserThere.isPresent());
    Assertions.assertEquals("gojo", isUserThere.get().getName());
    Assertions.assertEquals("goj@gmail.com", isUserThere.get().getEmail());
}

    @Test
    public void deleteUserByIdTest(){
        UserEntity newUser = new UserEntity("micky","mk@gmail.com");
        userService.createUser(newUser);

        assertTrue(userService.deleteUserById(newUser.getId()));
}
}

package com.CRUD.First.Crud.service;

import com.CRUD.First.Crud.entity.UserEntity;
import java.util.*;
public interface UserServiceInterface {
    UserEntity createUser(UserEntity usr);
     UserEntity updateUser(Integer userId , UserEntity usr);
     List<UserEntity> getAllUser();
    UserEntity getUserById(Integer userId);
     boolean deleteUserById(Integer userId);
}

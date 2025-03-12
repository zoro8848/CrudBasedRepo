package com.CRUD.First.Crud.service.usrService;

import com.CRUD.First.Crud.entity.UserEntity;
import com.CRUD.First.Crud.repository.UserRepository;
import com.CRUD.First.Crud.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository repo;

//    NOTE: is it should be void or return the response entity
    public UserEntity  createUser(UserEntity usr){
        repo.save(usr);
        return usr;
    }
    
    public UserEntity updateUser(Integer userId , UserEntity usr){
        Optional<UserEntity>  singleUser = repo.findById(userId);
        if(singleUser.isPresent()){
            System.out.println("user id true or not" + usr.getId());
            usr.setId(userId);
            System.out.println("user id true or not" + usr.getId());

            repo.save(usr);
            return usr;
        }
        return null;
    }

    public List<UserEntity> getAllUser(){
        return repo.findAll();
    }

    public UserEntity getUserById(Integer userId){
        Optional<UserEntity> singleUser = repo.findById(userId);

        if(singleUser.isPresent()){
            return singleUser.get();
        }else return null;

    }

    public boolean deleteUserById(Integer userId){
        Optional<UserEntity> isUserPresent = repo.findById(userId);
        if(isUserPresent.isPresent()){
            repo.deleteById(userId);
            return true;
        }else return false;
    }
}

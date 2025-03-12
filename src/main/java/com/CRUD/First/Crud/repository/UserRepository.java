package com.CRUD.First.Crud.repository;

import com.CRUD.First.Crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Integer> {

}

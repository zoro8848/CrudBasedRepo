package com.CRUD.First.Crud.controller;

import com.CRUD.First.Crud.entity.ApiResponse;
import com.CRUD.First.Crud.entity.UserEntity;
import com.CRUD.First.Crud.service.usrService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping(path = "/v1/api/user")
public class UserController {

   @Autowired
   UserService userService;

    @PostMapping(path = "/registerUser")
    public ResponseEntity<ApiResponse<UserEntity>> CreateUser(@Valid  @RequestBody UserEntity usr){
        try {
        /*
        //            UUID id = UUID.randomUUID();
        //            usr.setId(id.toString());
        //            repo.save(usr);
        */
         UserEntity createdUser =    userService.createUser(usr);
            ApiResponse<UserEntity> resp1 = new ApiResponse<>("Success" , "User Created Successfully" , createdUser);
            return new ResponseEntity<>(resp1,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Exception while creating user" + e);
            ApiResponse<UserEntity> errResponse = new ApiResponse("failure" , "Something went wrong" , null);
            return new ResponseEntity<>(errResponse , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/updateUser/{userId}")
    public ResponseEntity<ApiResponse<UserEntity>> UpdateUser(@PathVariable Integer userId ,@Valid  @RequestBody UserEntity usr){

      /*
        Optional<UserEntity> singleUser = repo.findById(userId);// optional is like a container and tells you there is or not in the bucket
        if(singleUser.isPresent()){
            usr.setId(userId);
            repo.save(usr);
            ApiResponse<UserEntity> successResponse = new ApiResponse("Success" , "User updated successfully" , usr);
            return new ResponseEntity<>(successResponse , HttpStatus.OK);
        }

        */
        UserEntity updatedUser = userService.updateUser(userId,usr);
        if(updatedUser != null){
            ApiResponse<UserEntity> successResponse = new ApiResponse("Success" , "User updated successfully" , updatedUser);
            return new ResponseEntity<>(successResponse , HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "User Not Found" , null) , HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public ResponseEntity<ApiResponse<UserEntity>> GetAllUser(){
        return new ResponseEntity<>(new ApiResponse("success" , "All user in system" , userService.getAllUser())
                , HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<ApiResponse<?>> GetUserById(@PathVariable Integer userId){
      /*  Optional<UserEntity> singleUser = repo.findById(userId);// optional is like a container and tells you there is or not in the bucket
        if(singleUser.isPresent()){
            return new ResponseEntity<>(new ApiResponse<>("success" , "found user with user_id: " + userId , singleUser.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "User Not Found" , null) , HttpStatus.NOT_FOUND);

    */
        UserEntity existedUserOrNot = userService.getUserById(userId);
        if(existedUserOrNot != null){
            return new ResponseEntity<>(new ApiResponse<>("success" , "found user with user_id: " + userId , existedUserOrNot),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "User Not Found" , null) , HttpStatus.NOT_FOUND);
    }

//    #TODO: add a message telling the user if the user not present in your db
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<ApiResponse<?>> DeleteUserById(@PathVariable Integer userId){

      /*  Optional<UserEntity> isUserThere = repo.findById(userId);
        if(isUserThere.isPresent()){
            repo.deleteById(userId);
            return new ResponseEntity<>(new ApiResponse("success" , "User removed from record" , null) , HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiResponse("failure" , "User Not found" , null) , HttpStatus.NOT_FOUND);
       */

    if(userService.deleteUserById(userId)){
        return new ResponseEntity<>(new ApiResponse<>("success" , "User removed from record" , null) , HttpStatus.OK);
    }
        return new ResponseEntity<>(new ApiResponse<>("failure" , "User Not found" , null) , HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/error")
    public ResponseEntity<String> FoundError(){
       String responseBody = "Something goes wrong";
       return new ResponseEntity<>(responseBody , HttpStatus.NOT_FOUND);
    }

}

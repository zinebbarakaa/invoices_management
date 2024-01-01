package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.UserRequest;
import com.fsts.gestion_factures.model.response.SuccessResponse;
import com.fsts.gestion_factures.model.response.UserResponse;
import com.fsts.gestion_factures.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest request){
          return  new ResponseEntity<>(userService.add(request),HttpStatus.CREATED);
    }

    @GetMapping("/get-all-user")
    public  ResponseEntity<List<UserResponse>> getAllUser(){
        return  new ResponseEntity<>(userService.get(),HttpStatus.OK);
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.get(id),HttpStatus.OK);
    }

    @PutMapping("update-user/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request,@PathVariable Long id){
        return  new ResponseEntity<>(userService.update(request,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteUser(@PathVariable Long id){
        userService.delete(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .message("User deleted successfully")
                .build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

}

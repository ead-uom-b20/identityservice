package com.lambda.identityservice.controller;

import com.lambda.identityservice.domain.UserDomain;
import com.lambda.identityservice.dto.ResponseDto;
import com.lambda.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/identity")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseDto getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public ResponseDto addNewUser(@RequestBody UserDomain userDomain){
        return userService.addNewUser(userDomain);
    }

    @GetMapping("/user/{id}")
    public  ResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/role/{role}")
    public ResponseDto getUsersByRole(@PathVariable String role){
        return userService.getUserByRole(role);
    }
}

package com.delete.Assignment.controller;

import com.delete.Assignment.model.UserDto;
import com.delete.Assignment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserControler {

    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> addNewUser(@RequestBody UserDto userDto) {
        try {
            userService.createNewUser(userDto);
            return new ResponseEntity<>("User created Succesfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("threw exception");
        }
        return new ResponseEntity<>("Exception return", HttpStatus.BAD_REQUEST);
    }
}
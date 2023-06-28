package com.example.demo.controllers;

import com.example.demo.models.UserDto;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserResourceController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public UserResourceController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public UserDto findByUsername(@PathVariable String username) {
        return new UserDto(userService.findByUsername(username));
    }

    @PostMapping("/user")
    public void create(@RequestBody UserDto user) {
        userService.saveUser(user);
    }


    @GetMapping("/userForDelete/{username}")
    public UserDto findByUsername1(@PathVariable String username) {
        return new UserDto(userService.findByUsername(username));
    }
    @PostMapping("/userForDelete")
    public void delete(@RequestBody UserDto user) {
        userService.deleteUserByUsername(user.getUsername());
    }
}

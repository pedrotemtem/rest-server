package com.appdetex.controller;

import com.appdetex.request.CreateUserRequest;
import com.appdetex.request.UpdateUserRequest;
import com.appdetex.response.UserResponse;
import com.appdetex.service.UserService;
import com.appdetex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserResponse> getAllUsers() {

        List<User> userList = userService.getAllUsers();
        List<UserResponse> userResponseList = new ArrayList<UserResponse>();

        userList.stream().forEach(user -> {
            userResponseList.add(new UserResponse(user));
        });

        return userResponseList;
    }

    @PostMapping("create")
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {

        User user = userService.createUser(createUserRequest);
        return new UserResponse(user);
    }

    @PutMapping("update")
    public UserResponse updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {

        User user = userService.updateUser(updateUserRequest);
        return new UserResponse(user);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable int id){

        return userService.deleteUser(id);
    }
}

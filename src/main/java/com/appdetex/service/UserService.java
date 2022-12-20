package com.appdetex.service;

import com.appdetex.repository.UserRepository;
import com.appdetex.entity.User;
import com.appdetex.request.CreateUserRequest;
import com.appdetex.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserRequest createUserRequest){

        User user = new User(createUserRequest);
        user = userRepository.save(user);
        return user;
    }

    public User updateUser(UpdateUserRequest updateUserRequest){

        User user = userRepository.findById(updateUserRequest.getId()).get();

        if(updateUserRequest.getName() != null && !updateUserRequest.getName().isEmpty()){
            user.setName(updateUserRequest.getName());
        }
        if(updateUserRequest.getEmail() != null && !updateUserRequest.getEmail().isEmpty()){
            user.setEmail(updateUserRequest.getEmail());
        }
        if(updateUserRequest.getPassword() != null && !updateUserRequest.getPassword().isEmpty()){
            user.setPassword(updateUserRequest.getPassword());
        }
        if(updateUserRequest.getRolesId() != 0){
            user.setRolesId(updateUserRequest.getRolesId());
        }

        user = userRepository.save(user);
        return user;
    }

    public String deleteUser(int id){

        userRepository.deleteById(id);
        return "User has been deleted successfully";
    }
}

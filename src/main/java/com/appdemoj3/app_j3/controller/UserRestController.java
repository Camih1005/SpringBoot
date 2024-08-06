package com.appdemoj3.app_j3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.appdemoj3.app_j3.models.User;
import com.appdemoj3.app_j3.models.dto.UserDto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("/api")
public class UserRestController {
@GetMapping("/v2/details/dto")
public UserDto details(){

    UserDto userDto = new UserDto();
    User user = new User();
    user.setNombre("Camilo");
    user.setApellido("Hernandez");
    userDto.setTitle("Desarrollando con springboot creativecode");
    userDto.setUser(user);
    return userDto;

}

@GetMapping("/list-details")
public List<User> listArrayDetails(){
    User user = new User();
    User user2 = new User();
    User user3 = new User();
    user.setNombre("Camilo");
    user.setApellido("Hernandez");
    user2.setNombre("Carlos");
    user2.setApellido("Aguilar");
    user3.setNombre("Daniel");
    user3.setApellido("Tobon");
    List<User> lstUser = Arrays.asList(user,user2,user3);
    
    return lstUser; 
}

// public Map<String, Object> details() {
//     User user = new User();
//     user.setNombre("Camilo");
//     user.setApellido("Hernandez");
//     Map<String,Object> map = new HashMap<>();
//     map.put("title", "Desarrollando con spring boot creaticode");
//     map.put("User", user);
//     return map;
}



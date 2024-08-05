package com.appdemoj3.app_j3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.appdemoj3.app_j3.models.User;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class UserRestController {
@GetMapping("/v2/details")
public Map<String, Object> details() {
    User user = new User();
    user.setNombre("Camilo");
    user.setApellido("Hernandez");
    Map<String,Object> map = new HashMap<>();
    map.put("title", "Desarrollando con spring boot creaticode");
    map.put("User", user);
    return map;
}



}

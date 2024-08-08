package com.appdemoj3.app_j3.controller;
import org.springframework.web.bind.annotation.RestController;
import com.appdemoj3.app_j3.models.User;
import com.appdemoj3.app_j3.models.dto.UserDto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

 @GetMapping("/list-details/{cedula}")
    public List<User> listArrayDetails(@PathVariable int cedula) {
     
        User user1 = new User();
        user1.setCedula(1);
        user1.setNombre("Camilo");
        user1.setApellido("Hernandez");

        User user2 = new User();
        user2.setCedula(2);
        user2.setNombre("Carlos");
        user2.setApellido("Aguilar");

        User user3 = new User();
        user3.setCedula(3);
        user3.setNombre("Daniel");
        user3.setApellido("Tobon");

 
        List<User> allUsers = Arrays.asList(user1, user2, user3);


        List<User> filteredUsers = allUsers.stream()
            .filter(user -> user.getCedula() == cedula)
            .collect(Collectors.toList());


        return filteredUsers;
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



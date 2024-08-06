package com.appdemoj3.app_j3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.appdemoj3.app_j3.models.User;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;




@Controller
public class UserController {

@GetMapping("/details")
public String details(Model model) {
    
User user = new User();
user.setNombre("Camilo");
user.setApellido("Hernandez");
user.setEmail(null);
// model.addAttribute("title", "Aprendiendo Spring");
model.addAttribute("user", user);
    return "details";
}

@GetMapping("/list")
public String list(Model model) {
    List<User> users = new ArrayList<>();

    User user = new User();
    User user2 = new User();
    user.setNombre("Camilo");
    user.setApellido("Hernandez");
    user.setEmail("camilo@gmail.com");
    user2.setNombre("Daniel");
    user2.setApellido("Tobon");
    user2.setEmail(null);
    users.add(user);
    users.add(user2);


    model.addAttribute("title", "Recorrer lista");
    model.addAttribute("users", users);

    return "list";
}

@GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form"; // Nombre del archivo de la plantilla HTML
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user, Model model) {
        // Aquí puedes procesar el objeto User
        model.addAttribute("user", user);
        return "result"; // Nombre del archivo de la plantilla HTML para mostrar resultados
    }

}

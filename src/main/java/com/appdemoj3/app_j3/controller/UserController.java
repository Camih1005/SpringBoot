package com.appdemoj3.app_j3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class UserController {

@GetMapping("/details")
public String details(Model model) {
    
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 11; j++) {
            int[] array;
            int num1 = i * j;
            model.addAttribute("titulo", num1);
        }
    }
    
    return "details";
}
@GetMapping("/main")
public String main() {
    return "main";
}



}

package com.appdemoj3.app_j3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdemoj3.app_j3.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/demovar")
public class PathVariableController {

    @GetMapping("/saludo/{message}")
    public ParamDto saludo(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMensaje(message);
        return param;
    }
    

}

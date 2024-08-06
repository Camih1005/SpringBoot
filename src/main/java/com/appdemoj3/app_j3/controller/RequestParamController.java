package com.appdemoj3.app_j3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdemoj3.app_j3.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {
@GetMapping("/foo")
public ParamDto foo(@RequestParam(required = false,defaultValue = "hola mundo")String mensaje) {
    
    ParamDto param = new ParamDto();
    param.setMensaje(mensaje);
    
    return param;
}



    
}

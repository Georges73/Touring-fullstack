package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Value("${spring.application.name}")
    private String serviceId;
	
	@Autowired
    private Environment env;
	
	@GetMapping("port")
    public String getPort(){
        return "Service is working at port : " + env.getProperty("local.server.port");
    }

}

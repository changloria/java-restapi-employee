package com.afs.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//url: localhost:8080/hello
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    public String getHelloMessage(){
        return "Hello Everyone~~~~~~~~";
    }
}

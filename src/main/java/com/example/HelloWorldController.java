package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello-world")
public class HelloWorldController {

    @Get
    public String helloWorld() {
        return "Hello World!";
    }
}

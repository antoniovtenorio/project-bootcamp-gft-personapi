package com.projetopersonapi.dio.personapi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {

    @GetMapping
    public String getBook() {
       return "API return test!";
    }
}

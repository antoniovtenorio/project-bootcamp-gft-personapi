package com.projetopersonapi.dio.personapi.resources;

import com.projetopersonapi.dio.personapi.dto.responses.MessageResponseDTO;
import com.projetopersonapi.dio.personapi.entities.Person;
import com.projetopersonapi.dio.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {


    private PersonRepository repository;

    @Autowired
    public PersonResource(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
       Person savedPerson =  repository.save(person);
       return MessageResponseDTO
               .builder()
               .message("Created person with Id: " + savedPerson.getId())
               .build();
    }
}

package com.projetopersonapi.dio.personapi.resources;

import com.projetopersonapi.dio.personapi.dto.requests.PersonDTO;
import com.projetopersonapi.dio.personapi.dto.responses.MessageResponseDTO;
import com.projetopersonapi.dio.personapi.exceptions.PersonNotFoundException;
import com.projetopersonapi.dio.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {

    private PersonService service;

    @Autowired
    public PersonResource(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return service.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return service.listaAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }
}

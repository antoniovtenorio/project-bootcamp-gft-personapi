package com.projetopersonapi.dio.personapi.services;

import com.projetopersonapi.dio.personapi.dto.requests.PersonDTO;
import com.projetopersonapi.dio.personapi.dto.responses.MessageResponseDTO;
import com.projetopersonapi.dio.personapi.entities.Person;
import com.projetopersonapi.dio.personapi.exceptions.PersonNotFoundException;
import com.projetopersonapi.dio.personapi.mapper.PersonMapper;
import com.projetopersonapi.dio.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository repository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = repository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with Id: " + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listaAll() {
        List<Person> allPeople = repository.findAll();
        return  allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = repository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}

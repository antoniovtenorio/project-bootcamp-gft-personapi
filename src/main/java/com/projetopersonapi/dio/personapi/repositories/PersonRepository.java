package com.projetopersonapi.dio.personapi.repositories;

import com.projetopersonapi.dio.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

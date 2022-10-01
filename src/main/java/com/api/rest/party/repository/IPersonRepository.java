package com.api.rest.party.repository;

import com.api.rest.party.entitys.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IPersonRepository extends CrudRepository<Person, Long> {

    Collection<Person> findAll();
}

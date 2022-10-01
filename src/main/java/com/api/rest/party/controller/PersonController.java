package com.api.rest.party.controller;

import com.api.rest.party.entitys.Party;
import com.api.rest.party.entitys.Person;
import com.api.rest.party.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private IPersonRepository personRepository;

    @GetMapping
    public ResponseEntity<Collection<Person>> listPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElseThrow();

        if(person != null) {
            return new ResponseEntity<>(personRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}/partys")
    public ResponseEntity<Collection<Party>> listPersonOfPartys(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElseThrow();

        if(person != null) {
            return new ResponseEntity<>(person.getPartys(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

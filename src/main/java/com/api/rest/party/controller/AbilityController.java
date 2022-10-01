package com.api.rest.party.controller;


import com.api.rest.party.entitys.Ability;
import com.api.rest.party.repository.IAbilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/abilitys")
public class AbilityController {

    private IAbilityRepository abilityRepository;

    @GetMapping
    public ResponseEntity<Collection<Ability>> listAbilitys() {
        return new ResponseEntity<>(abilityRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ability> consultAbility(@PathVariable Long id) {
        Ability ability = abilityRepository.findById(id).orElseThrow();

        if(ability != null) {
            return new ResponseEntity<>(abilityRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveAbility(@RequestBody Ability ability) {
        return new ResponseEntity<>(abilityRepository.save(ability), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbility(@PathVariable Long id) {
        abilityRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

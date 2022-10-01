package com.api.rest.party.controller;

import com.api.rest.party.entitys.Party;
import com.api.rest.party.repository.IPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/partys")
public class PartyController {

    @Autowired
    private IPartyRepository partyRepository;

    @GetMapping
    public ResponseEntity<Collection<Party>> listPartys() {
        return new ResponseEntity<>(partyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> consultParty(@PathVariable Long id) {
        Party party = partyRepository.findById(id).orElseThrow();

        if(party != null) {
            return new ResponseEntity<>(partyRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveParty(@RequestBody Party party) {
        return new ResponseEntity<>(partyRepository.save(party), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id) {
        partyRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

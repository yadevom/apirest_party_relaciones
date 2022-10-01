package com.api.rest.party.repository;

import com.api.rest.party.entitys.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IPartyRepository extends CrudRepository<Party, Long> {

    Collection<Party> findAll();
}

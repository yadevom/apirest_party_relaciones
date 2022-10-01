package com.api.rest.party.repository;

import com.api.rest.party.entitys.Ability;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IAbilityRepository extends CrudRepository<Ability, Long> {

    Collection<Ability> findAll();
}

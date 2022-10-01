package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "abilitys")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ability_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private  Level level;
    // Muchas habilidades puede tener una persona
    @ManyToMany
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}

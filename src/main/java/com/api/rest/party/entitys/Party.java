package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "partys")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;
    private String place;
    @Column(name = "party_date")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date partyDate;
    // A una fiesta puede asistir muchas personas
    @ManyToMany
    @JoinTable(
            name = "persons_partys",
            joinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    )
    private Set<Person> persons = new HashSet<>();
}

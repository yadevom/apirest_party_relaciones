package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    private String name;
    private int age;
    // Persona puede tener muchas habilidades, cascade para eliminar la persona como las habilidades en las 2 tablas
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Ability> abilitys = new HashSet<>();

    // Relacion muchos a muchos, la persona puede asisitr a muchas fiestas
    // Se creara una tabla intermedia y unas los ID de las personas y el ID de la persona referenciada
    @ManyToMany
    // Evitar problemas de recursividad para cuando retorne una persona no se quede en un retorno de lista infinita de fiestas asistidas
    // Tambien para que se pueda guardar y evitar la serializacion se omita, pero al traer los datos trabaje de forma normal
    @JsonBackReference
    @JoinTable(
            name = "persons_partys",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id")
    )
    private Set<Party> partys = new HashSet<>();
}


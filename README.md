 # RESTful Party

### Desarrollo de una API de servicios web RESTful
Se desarrolla API Rest con las relaciones que existen para un aplicacion de manejo de fiestas, mediante Spring Boot
estos servicios web RESTful realizaran operaciones CRUD con MySQL.


### Relacion Bidireccional
@ManyToMany, @OneToMany, ManyToOne.

Imagen de la relación a realizar en BD:

![Image text](https://github.com/yadevom/relacion_bd.png)

### Dependencias utilizadas para App
- MySQL Drive
- Spring Data JPA
- Spring Web
- Spring Boot DevTools
- Validation

### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
create database party_people;
```
### Configuración conexión BD
En el archivio application.properties, indicar el nombre de la BD, username y password:
```
spring.datasource.url = jdbc:mysql://localhost:3306/party_people 
spring.datasource.username = $USER
spring.datasource.password = $PASS
```
### Script SQL
Consultas de tablas:
```
SELECT * FROM party_people.abilitys;
SELECT * FROM party_people.partys;
SELECT * FROM party_people.persons;
SELECT * FROM party_people.persons_partys;
```

Crear las habilidades y asociar a persona:
```
INSERT INTO party_people.abilitys
(ability_id, level, name, person_id) VALUES
(1, "BAD", "Bailar", 1),
(2, "MEDIUM", "Cantar", 1),
(3, "EXCELLENT", "Tocar", 1);
```

Relacionar persona con muchas fiestas
```
INSERT INTO party_people.persons_partys
(person_id, party_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 2),
(3, 3);
```

### Consultas end point persona
Consulta todas las persona - GET ```http://localhost:8080/api/persons```

Crear persona - POST ```http://localhost:8080/api/persons```

```
{
    "name": "Jose",
    "age": 10
}
```

Consulta fiestas relacionadas a la persona - GET ```http://localhost:8080/api/persons/1/partys```

Consulta persona especifica - GET ```http://localhost:8080/api/person/2```

Eliminar persona - DELETE ```http://localhost:8080/api/library/2```


### Consultas end point fiestas
Registrar una fiesta - POST ```http://localhost:8080/api/partys```
```
{
    "place": "El Poblado",
    "partyDate": "2022-10-01"
}
```

Consulta todas las fiestas- GET ```http://localhost:8080/api/partys```


Consulta fiesta en especifico - GET ```http://localhost:8080/api/partys/2```

Eliminar fiesta - DELETE ```http://localhost:8080/api/partys/2```

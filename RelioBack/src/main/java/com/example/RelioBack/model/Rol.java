package com.example.RelioBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 20)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol",length = 20)
    private ERol nombre_rol;

}
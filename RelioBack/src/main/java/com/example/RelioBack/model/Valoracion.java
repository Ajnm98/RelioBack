package com.example.RelioBack.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fecha_publicacion;

    @OneToOne
    @JoinColumn(name = "usuario_id_emisor")
    private Usuario usuario_emisor;

}

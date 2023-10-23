package com.example.RelioBack.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DATOS_OCIO")
public class Datos_Ocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "pais")
    private String pais;

    @NotBlank
    @Column(name = "direccion")
    private String direccion;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ocio_tipo",
            joinColumns = @JoinColumn(name = "ocio_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_id"))
    private Set<Tipo_Lugar> tipo_lugar = new HashSet<>();

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "url_icono")
    private String url_icono;

    @Column(name = "url_banner")
    private String url_banner;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}

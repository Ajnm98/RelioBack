package com.example.RelioBack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "relio")
public class Relio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "ocio_id")
    private Usuario ocio;

    @OneToOne
    @JoinColumn(name = "fiesta_id")
    private Fiestas fiestas;

    @OneToOne
    @JoinColumn(name = "usuario_id_emisor")
    private Usuario usuario_emisor;

    @Column(name = "personas")
    private Integer personas;

    @Column(name = "max_personas")
    private Integer max_personas;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fecha_publicacion;

    @Column(name = "fecha_inicio")
    private LocalDateTime start;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "relio_receptores",
            joinColumns = @JoinColumn(name = "relio_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Usuario> usuarios_receptores = new HashSet<>();

    @Column(name = "lleno")
    private Integer lleno;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "valoracion",
            joinColumns = @JoinColumn(name = "relio_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Usuario> valoracion = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "publicaciones",
            joinColumns = @JoinColumn(name = "relio_id"),
            inverseJoinColumns = @JoinColumn(name = "publicacion_id"))
    private Set<Publicacion> publicaciones_relio = new HashSet<>();

}

package com.example.RelioBack.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "usuario_id_emisor")
    private Usuario usuario_emisor;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fecha_publicacion;

    @Column(name = "texto")
    private String texto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "likes_comentarios",
            joinColumns = @JoinColumn(name = "comentarios_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Usuario> likes = new HashSet<>();

}

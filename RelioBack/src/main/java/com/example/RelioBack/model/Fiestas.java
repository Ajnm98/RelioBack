package com.example.RelioBack.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "fiestas")
public class Fiestas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_inicio")
    private LocalDateTime start;

    @Column(name = "fecha_fin")
    private LocalDateTime end;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url_foto")
    private String url_foto;

    @OneToOne
    @JoinColumn(name = "ocio_id")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl_foto() {
        return url_foto;
    }
}

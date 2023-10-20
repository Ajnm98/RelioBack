package com.example.RelioBack.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Setter
@Entity
@Table(name = "tipos")
public class Tipo_Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ETipo_Lugar name;

    public Tipo_Lugar() {

    }

    public Tipo_Lugar(ETipo_Lugar name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ETipo_Lugar getName() {
        return name;
    }

    public void setName(ETipo_Lugar name) {
        this.name = name;
    }

}

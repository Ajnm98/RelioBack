package com.example.RelioBack.model.dto;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class RelioDTO {
    private Integer id;
    private String descripcion;
    private Integer fiestas;
    private Integer usuario_emisor;
    private Integer personas;
    private Integer max_personas;
    private LocalDateTime fecha_publicacion;
    private LocalDateTime start;
    private Integer usuarios_receptores;
    private Integer lleno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFiestas() {
        return fiestas;
    }

    public void setFiestas(Integer fiestas) {
        this.fiestas = fiestas;
    }

    public Integer getUsuario_emisor() {
        return usuario_emisor;
    }

    public void setUsuario_emisor(Integer usuario_emisor) {
        this.usuario_emisor = usuario_emisor;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public Integer getMax_personas() {
        return max_personas;
    }

    public void setMax_personas(Integer max_personas) {
        this.max_personas = max_personas;
    }

    public LocalDateTime getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDateTime fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Integer getUsuarios_receptores() {
        return usuarios_receptores;
    }

    public void setUsuarios_receptores(Integer usuarios_receptores) {
        this.usuarios_receptores = usuarios_receptores;
    }

    public Integer getLleno() {
        return lleno;
    }

    public void setLleno(Integer lleno) {
        this.lleno = lleno;
    }
}

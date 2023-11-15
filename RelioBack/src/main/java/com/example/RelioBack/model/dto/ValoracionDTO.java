package com.example.RelioBack.model.dto;

import com.example.RelioBack.model.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class ValoracionDTO {

    private String descripcion;
    private Integer puntuacion;
    private Integer usuario_emisor;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getUsuario_emisor() {
        return usuario_emisor;
    }

    public void setUsuario_emisor(Integer usuario_emisor) {
        this.usuario_emisor = usuario_emisor;
    }
}

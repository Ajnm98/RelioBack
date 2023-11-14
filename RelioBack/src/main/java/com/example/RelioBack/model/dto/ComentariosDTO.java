package com.example.RelioBack.model.dto;

import com.example.RelioBack.model.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ComentariosDTO {


    private Integer usuario_emisor;

    private String texto;

    public Integer getUsuario_emisor() {
        return usuario_emisor;
    }

    public void setUsuario_emisor(Integer usuario_emisor) {
        this.usuario_emisor = usuario_emisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

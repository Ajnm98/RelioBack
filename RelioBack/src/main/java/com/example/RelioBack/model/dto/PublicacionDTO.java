package com.example.RelioBack.model.dto;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;

import javax.persistence.*;
import java.util.Set;

public class PublicacionDTO {

    private Integer id;
    private String url_foto;
    private String descripcion;
    private Integer usuario_id;
    private Integer fiesta_id;

    private Integer relio_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getFiesta_id() {
        return fiesta_id;
    }

    public void setFiesta_id(Integer fiesta_id) {
        this.fiesta_id = fiesta_id;
    }

    public Integer getRelio_id() {
        return relio_id;
    }

    public void setRelio_id(Integer relio_id) {
        this.relio_id = relio_id;
    }

}

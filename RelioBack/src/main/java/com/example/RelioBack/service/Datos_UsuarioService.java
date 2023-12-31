package com.example.RelioBack.service;


import com.example.RelioBack.model.Datos_Usuario;
import org.springframework.stereotype.Service;


public interface Datos_UsuarioService {

    Datos_Usuario getDatosUsuarioById(Long id);

    void updateDatosUsuario(Datos_Usuario datosUsuario, Datos_Usuario usuario);
    Datos_Usuario createDatosUsuario(Datos_Usuario datosUsuario);
}

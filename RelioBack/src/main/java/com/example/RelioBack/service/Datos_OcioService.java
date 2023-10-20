package com.example.RelioBack.service;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Datos_Usuario;
import org.springframework.stereotype.Service;


public interface Datos_OcioService {
    Datos_Ocio getDatosOcioById(Long id);

    void updateDatosUsuario(Datos_Ocio datosUsuario, Datos_Ocio usuario);

    Datos_Ocio createDatosUsuario(Datos_Ocio datosUsuario);
}

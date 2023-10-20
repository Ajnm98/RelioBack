package com.example.RelioBack.service.Imple;

import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.repository.Datos_UsuarioRepository;
import com.example.RelioBack.service.Datos_UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Datos_UsuarioServiceImpl implements Datos_UsuarioService {


    @Autowired
    Datos_UsuarioRepository datosUsuarioRepository;
    @Override
    public Datos_Usuario getDatosUsuarioById(Long id) {
        return datosUsuarioRepository.findDatosUsuariosByUsuario_Id(id);
    }

    @Override
    public Datos_Usuario createDatosUsuario(Datos_Usuario datosUsuario){
        return datosUsuarioRepository.save(datosUsuario);
    }

    @Override
    public Datos_Usuario updateDatosUsuario(Datos_Usuario datosUsuario) {
        Datos_Usuario datosUsuario1 = datosUsuario;
        datosUsuario1.setUsuario(datosUsuario.getUsuario());
        return datosUsuarioRepository.modifyUsuario(datosUsuario1);

    }


}

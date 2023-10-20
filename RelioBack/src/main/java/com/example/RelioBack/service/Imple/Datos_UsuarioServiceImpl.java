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
    public void updateDatosUsuario(Datos_Usuario datosUsuario, Datos_Usuario usuario) {
        Datos_Usuario datosUsuario1 = datosUsuario;
        if(datosUsuario1.getNombre()==null){
            datosUsuario1.setNombre(usuario.getNombre());
        }
        if(datosUsuario1.getBio()==null){
            datosUsuario1.setBio(usuario.getBio());
        }
        if(datosUsuario1.getPais()==null){
            datosUsuario1.setPais(usuario.getPais());
        }
        if(datosUsuario1.getDireccion()==null){
            datosUsuario1.setDireccion(usuario.getDireccion());
        }
        if(datosUsuario1.getGenero()==null){
            datosUsuario1.setGenero(usuario.getGenero());
        }
        if(datosUsuario1.getUrl_icono()==null){
            datosUsuario1.setUrl_icono(usuario.getUrl_icono());
        }
        if(datosUsuario1.getUrl_banner()==null){
            datosUsuario1.setUrl_banner(usuario.getUrl_banner());
        }

         datosUsuarioRepository.modifyUsuario(datosUsuario1.getNombre(), datosUsuario1.getBio(),datosUsuario1.getPais(), datosUsuario1.getDireccion()
        , datosUsuario1.getGenero(), datosUsuario1.getUrl_icono(), datosUsuario1.getUrl_banner(), datosUsuario1.getUsuario().getId());

    }


}

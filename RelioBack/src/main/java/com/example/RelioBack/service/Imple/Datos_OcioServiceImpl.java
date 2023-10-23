package com.example.RelioBack.service.Imple;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.model.Tipo_Lugar;
import com.example.RelioBack.repository.Datos_OcioRepository;
import com.example.RelioBack.service.Datos_OcioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Datos_OcioServiceImpl implements Datos_OcioService {
    @Autowired
    Datos_OcioRepository datosOcioRepository;
    @Override
    public Datos_Ocio getDatosOcioById(Long id) {
        return datosOcioRepository.findDatosUsuariosByUsuario_Id(id);
    }

    @Override
    public void updateDatosUsuario(Datos_Ocio datosUsuario, Datos_Ocio usuario) {
        Datos_Ocio datosUsuario1 = datosUsuario;
        if(datosUsuario1.getNombre()==null){
            datosUsuario1.setNombre(usuario.getNombre());
        }
        if(datosUsuario1.getTipo_lugar()==null){
            datosUsuario1.setTipo_lugar(usuario.getTipo_lugar());
        }
        if(datosUsuario1.getPais()==null){
            datosUsuario1.setPais(usuario.getPais());
        }
        if(datosUsuario1.getDireccion()==null){
            datosUsuario1.setDireccion(usuario.getDireccion());
        }
        if(datosUsuario1.getTelefono()==null){
            datosUsuario1.setTelefono(usuario.getTelefono());
        }
        if(datosUsuario1.getUrl_icono()==null){
            datosUsuario1.setUrl_icono(usuario.getUrl_icono());
        }
        if(datosUsuario1.getUrl_banner()==null){
            datosUsuario1.setUrl_banner(usuario.getUrl_banner());
        }

        datosOcioRepository.modifyUsuario(datosUsuario1.getNombre(), datosUsuario1.getPais(),datosUsuario1.getDireccion()
                , datosUsuario1.getTelefono(), datosUsuario1.getUrl_icono(), datosUsuario1.getUrl_banner(), datosUsuario1.getUsuario().getId());

    }

    @Override
    public Datos_Ocio createDatosUsuario(Datos_Ocio datosUsuario){

        return datosOcioRepository.save(datosUsuario);
    }




}

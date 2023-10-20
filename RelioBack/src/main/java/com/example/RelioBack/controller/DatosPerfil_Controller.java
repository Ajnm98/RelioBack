package com.example.RelioBack.controller;


import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.repository.UsuarioRepository;
import com.example.RelioBack.service.Datos_OcioService;
import com.example.RelioBack.service.Datos_UsuarioService;
import com.example.RelioBack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/datosPerfil")
public class DatosPerfil_Controller {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Datos_OcioService datosOcioService;

    @Autowired
    Datos_UsuarioService datosUsuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping(value = "/buscarUsuario/{id}")
    public Datos_Usuario getDatosUsuarioById(@PathVariable long id) {
        return datosUsuarioService.getDatosUsuarioById(id);
    }

    @PostMapping(value = "/modify/{id}")
    public void modifyDatosUsuario(@PathVariable long id,@RequestBody Datos_Usuario datosUsuario) {
        Datos_Usuario usuario = datosUsuarioService.getDatosUsuarioById(id);
        Usuario usuario1 = usuarioRepository.findById(id);
        if(usuario!=null){
        datosUsuario.setUsuario(usuario1);
        datosUsuarioService.updateDatosUsuario(datosUsuario, usuario);
        }
        else{
            datosUsuario.setUsuario(usuario1);
            datosUsuarioService.createDatosUsuario(datosUsuario);
        }
    }

    @GetMapping(value = "/buscarOcio/{id}")
    public Datos_Ocio getDatosOcioById(@PathVariable long id) {
        return datosOcioService.getDatosOcioById(id);
    }


    @PostMapping(value = "/modifyOcio/{id}")
    public void modifyDatosOcio(@PathVariable long id,@RequestBody Datos_Ocio datosOcio) {
        Datos_Ocio usuario = datosOcioService.getDatosOcioById(id);
        Usuario usuario1 = usuarioRepository.findById(id);
        if(usuario!=null){
            datosOcio.setUsuario(usuario1);
            datosOcioService.updateDatosUsuario(datosOcio, usuario);
        }
        else{
            datosOcio.setUsuario(usuario1);
            datosOcioService.createDatosUsuario(datosOcio);
        }
    }




}

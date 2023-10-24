package com.example.RelioBack.controller;


import com.example.RelioBack.model.*;
import com.example.RelioBack.payload.request.Tipo_lugarRequest;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.Datos_OcioRepository;
import com.example.RelioBack.repository.Datos_UsuarioRepository;
import com.example.RelioBack.repository.Tipo_LugarRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import com.example.RelioBack.service.Datos_OcioService;
import com.example.RelioBack.service.Datos_UsuarioService;
import com.example.RelioBack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    Tipo_LugarRepository tipoLugarRepository;

    @Autowired
    Datos_OcioRepository datosOcioRepository;

    @Autowired
    Datos_UsuarioRepository datosUsuarioRepository;

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

    @PostMapping(value = "/anadirTipo_Lugar/{id}")
    public ResponseEntity<?> anadirTipo(@PathVariable long id, @Valid @RequestBody Tipo_lugarRequest tipoLugarRequest) {
        Set<String> strRoles = tipoLugarRequest.getTipo_lugar();
        Set<Tipo_Lugar> tiposLugar = new HashSet<>();

            strRoles.forEach(role -> {
                switch (role) {
                    case "DISCOTECA":
                        Tipo_Lugar adminRole = tipoLugarRepository.findByName(ETipo_Lugar.DISCOTECA)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole);

                        break;
                    case "SALA_DE_FIESTAS":
                        Tipo_Lugar adminRole1 = tipoLugarRepository.findByName(ETipo_Lugar.SALA_DE_FIESTAS)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole1);

                        break;
                    case "RESTAURANTE":
                        Tipo_Lugar adminRole2 = tipoLugarRepository.findByName(ETipo_Lugar.RESTAURANTE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole2);

                        break;
                    case "BAR_DE_COPAS":
                        Tipo_Lugar adminRole3 = tipoLugarRepository.findByName(ETipo_Lugar.BAR_DE_COPAS)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole3);

                        break;
                    case "PUB":
                        Tipo_Lugar adminRole4 = tipoLugarRepository.findByName(ETipo_Lugar.PUB)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole4);

                        break;
                    case "TERRAZA":
                        Tipo_Lugar adminRole5 = tipoLugarRepository.findByName(ETipo_Lugar.TERRAZA)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole5);

                        break;
                    case "CAFETERIA":
                        Tipo_Lugar adminRole6 = tipoLugarRepository.findByName(ETipo_Lugar.CAFETERIA)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole6);

                        break;
                    case "CAFE_BAR":
                        Tipo_Lugar adminRole7 = tipoLugarRepository.findByName(ETipo_Lugar.CAFE_BAR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole7);

                        break;
                    case "SALA_DE_BAILE":
                        Tipo_Lugar adminRole8 = tipoLugarRepository.findByName(ETipo_Lugar.SALA_DE_BAILE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole8);

                        break;
                    case "SALON_CELEBRACIONES":
                        Tipo_Lugar adminRole9 = tipoLugarRepository.findByName(ETipo_Lugar.SALON_CELEBRACIONES)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole9);

                        break;
                    case "SALA_CONCIERTOS":
                        Tipo_Lugar adminRole10 = tipoLugarRepository.findByName(ETipo_Lugar.SALA_CONCIERTOS)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole10);

                        break;
                    case "TEATRO":
                        Tipo_Lugar adminRole11 = tipoLugarRepository.findByName(ETipo_Lugar.TEATRO)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(adminRole11);

                        break;


                    default:
                        Tipo_Lugar userRole = tipoLugarRepository.findByName(ETipo_Lugar.AIRE_LIBRE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        tiposLugar.add(userRole);
                }
            });


        Datos_Ocio datosOcio = datosOcioRepository.findDatosUsuariosByUsuario_Id(id);



        datosOcio.setTipo_lugar(tiposLugar);
        datosOcioRepository.save(datosOcio);

        return ResponseEntity.ok(new MessageResponse("Añadido correctamente"));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/allOcio")
    public ResponseEntity<?> allOcio() {
        List<Datos_Ocio> listOcio= datosOcioRepository.findAll();
        return ResponseEntity.ok(listOcio);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allUsuarios")
    public ResponseEntity<?> allUsuarios() {
        List<Datos_Usuario> listUsuario= datosUsuarioRepository.findAll();
        return ResponseEntity.ok(listUsuario);
    }



        }





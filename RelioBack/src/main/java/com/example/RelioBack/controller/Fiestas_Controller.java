package com.example.RelioBack.controller;

import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.FiestasRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import com.example.RelioBack.service.FiestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fiestas")
public class Fiestas_Controller {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    FiestasRepository fiestasRepository;

    @Autowired
    FiestasService fiestasService;

    @RequestMapping(method = RequestMethod.POST, value = "/create/{id}")
    public ResponseEntity<?> createFiestas(@PathVariable long id, @RequestBody Fiestas fiestas) {
        Usuario usuario = usuarioRepository.findById(id);
        fiestas.setUsuario(usuario);

        try{
            fiestasRepository.save(fiestas);
            return ResponseEntity.ok(new MessageResponse("Creado correctamente"));

        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify/{id}")
    public ResponseEntity<?> modifyFiestas(@PathVariable long id, @RequestBody Fiestas fiestas) {
        try {
            fiestasService.updateFiestas(id, fiestas);
            return ResponseEntity.ok(new MessageResponse("Modificado correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }
}

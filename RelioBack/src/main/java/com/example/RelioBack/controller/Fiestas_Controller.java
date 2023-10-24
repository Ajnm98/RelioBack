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

import java.time.LocalDateTime;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarFiesta/{id}")
    public ResponseEntity<?> deleteFiesta(@PathVariable Long id) {
        try { fiestasRepository.delete(fiestasRepository.buscarFiesta(id));
            return ResponseEntity.ok(new MessageResponse("Borrado correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Fiestas> allFiesta() {
        List<Fiestas> listFiestas= fiestasRepository.findAll();
        return listFiestas;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myFiestas/{id}")
    public ResponseEntity<?> myFiestaS(@PathVariable Long id) {
        List<Fiestas> listFiestas = fiestasRepository.findAllByOcio_id(id);
        if(listFiestas.isEmpty()){
            return ResponseEntity.ok(new MessageResponse("No hay fiestas"));
        }else {
            return ResponseEntity.ok(listFiestas);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allVigente")
    public ResponseEntity<?> allVigente() {
        LocalDateTime vigente = LocalDateTime.now();
        List<Fiestas> listFiestas = fiestasRepository.findFiestasVigentes(vigente);
        if(listFiestas.isEmpty()){
            return ResponseEntity.ok(new MessageResponse("No hay fiestas"));
        }
        else{
            return ResponseEntity.ok(listFiestas);
        }

    }
}

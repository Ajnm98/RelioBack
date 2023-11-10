package com.example.RelioBack.controller;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.dto.PublicacionDTO;
import com.example.RelioBack.model.dto.RelioDTO;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.FiestasRepository;
import com.example.RelioBack.repository.PublicacionRepository;
import com.example.RelioBack.repository.RelioRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/publicacion")
public class Publicacion_Controller {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RelioRepository relioRepository;

    @Autowired
    FiestasRepository fiestasRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/create/{id}")
    public ResponseEntity<?> createRelio(@PathVariable long id, @RequestBody PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        Usuario usuario = usuarioRepository.findById(id);
        publicacion.setUsuario(usuario);
        Relio relio = relioRepository.findById(publicacionDTO.getRelio_id());
        publicacion.setRelio_id(relio);
        Fiestas fiestas = fiestasRepository.buscarFiesta(publicacionDTO.getFiesta_id());
        publicacion.setFiesta(fiestas);
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setUrl_foto(publicacionDTO.getUrl_foto());

        try{
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(new MessageResponse("Creado correctamente"));

        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }



}

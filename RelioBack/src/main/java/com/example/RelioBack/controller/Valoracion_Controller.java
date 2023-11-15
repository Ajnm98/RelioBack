package com.example.RelioBack.controller;

import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.Valoracion;
import com.example.RelioBack.model.dto.ComentariosDTO;
import com.example.RelioBack.model.dto.ValoracionDTO;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.PublicacionRepository;
import com.example.RelioBack.repository.RelioRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import com.example.RelioBack.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/valoracion")
public class Valoracion_Controller {

    @Autowired
    PublicacionRepository publicacionRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RelioRepository relioRepository;
    @Autowired
    ValoracionRepository valoracionRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/create/{id}")
    public ResponseEntity<?> crearValoracion(@PathVariable long id, @RequestBody ValoracionDTO valoracionDTO) {

        Relio relio = relioRepository.findById(id);
        Usuario usuario = usuarioRepository.findById(valoracionDTO.getUsuario_emisor());
        Valoracion valoracion = new Valoracion();

        try {
            valoracion.setDescripcion(valoracionDTO.getDescripcion());
            valoracion.setPuntuacion(valoracionDTO.getPuntuacion());
            valoracion.setUsuario_emisor(usuario);
            valoracion.setFecha_publicacion(LocalDateTime.now());
            relio.getValoracion().add(valoracion);
            relioRepository.save(relio);
//            valoracionRepository.save(valoracion);
            return ResponseEntity.ok(new MessageResponse("Añadido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(e);
        }




    }


}

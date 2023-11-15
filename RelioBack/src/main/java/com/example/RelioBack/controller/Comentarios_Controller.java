package com.example.RelioBack.controller;


import com.example.RelioBack.model.Comentarios;
import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.dto.ComentariosDTO;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.ComentariosRepository;
import com.example.RelioBack.repository.PublicacionRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/comentarios")
public class Comentarios_Controller {


    @Autowired
    PublicacionRepository publicacionRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ComentariosRepository comentariosRepository;


    @RequestMapping(method = RequestMethod.POST, value = "/create/{id}")
    public ResponseEntity<?> crearComentario(@PathVariable long id, @RequestBody ComentariosDTO comentarios) {

        Publicacion publicacion = publicacionRepository.findById(id);
        Comentarios comentarios1 = new Comentarios();
        if(comentarios.getTexto()!=null){
            comentarios1.setTexto(comentarios.getTexto());
        }else{
            return ResponseEntity.ok(new MessageResponse("Tienes que añadir texto"));
        }
        Usuario usuario = usuarioRepository.findById(comentarios.getUsuario_emisor());
        comentarios1.setUsuario_emisor(usuario);
        comentarios1.setFecha_publicacion(LocalDateTime.now());
        try {
            publicacion.getComentarios().add(comentarios1);
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(new MessageResponse("Añadido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}/{id2}")
    public ResponseEntity<?> deleteComentario(@PathVariable long id,@PathVariable long id2 ) {
        Comentarios comentarios = comentariosRepository.findById(id);
        Publicacion publicacion = publicacionRepository.findById(id2);
        publicacion.getComentarios().remove(comentarios);
        try {

            comentariosRepository.delete(comentarios);
            return ResponseEntity.ok(new MessageResponse("Borrado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/modify/{id}")
    public ResponseEntity<?> modifyComentario(@PathVariable long id, @RequestBody String texto) {
        Comentarios comentarios = comentariosRepository.findById(id);
        comentarios.setTexto(texto);

        try {
            comentariosRepository.save(comentarios);
            return ResponseEntity.ok(new MessageResponse("Editado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }



}

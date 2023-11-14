package com.example.RelioBack.controller;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.dto.ModifyPublicacionDTO;
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

import java.util.List;
import java.util.Set;

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
    public ResponseEntity<?> createPublicacion(@PathVariable long id, @RequestBody PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        Usuario usuario = usuarioRepository.findById(id);
        publicacion.setUsuario(usuario);
        Relio relio = relioRepository.findById(publicacionDTO.getRelio_id());
        publicacion.setRelio_id(relio);
        Fiestas fiestas = fiestasRepository.buscarFiesta(publicacionDTO.getFiesta_id());
        publicacion.setFiesta(fiestas);
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setUrl_foto(publicacionDTO.getUrl_foto());

        try {
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(new MessageResponse("Creado correctamente"));

        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify/{id}")
    public ResponseEntity<?> modifyPublicacion(@PathVariable long id, @RequestBody ModifyPublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionRepository.findById(id);

        publicacion.setDescripcion(publicacionDTO.getDescripcion());

        try {
            publicacionRepository.modifyPublicacion(publicacion.getDescripcion(), publicacion.getId());
            return ResponseEntity.ok(new MessageResponse("Modificado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarPublicacion/{id}")
    public ResponseEntity<?> deletePublicacion(@PathVariable long id) {
        try {
            publicacionRepository.delete(publicacionRepository.findById(id));
            return ResponseEntity.ok(new MessageResponse("Borrado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEtiquetado/{id}")
    public ResponseEntity<?> addEtiquetado(@PathVariable long id, @RequestBody List<String> usuarios) {

        Publicacion publicacion = publicacionRepository.findById(id);
        try {
            for (String u : usuarios) {
                Usuario usuario = usuarioRepository.buscarPorUsername(u);
                publicacion.getPublicacion_etiquetados().add(usuario);
            }
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(new MessageResponse("Añadido correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteEtiquetado/{id}")
    public ResponseEntity<?> deleteEtiquetado(@PathVariable long id, @RequestBody List<String> usuarios) {

        Publicacion publicacion = publicacionRepository.findById(id);
        try {
            for (String u : usuarios) {
                Usuario usuario = usuarioRepository.buscarPorUsername(u);
                publicacion.getPublicacion_etiquetados().remove(usuario);
            }
            publicacionRepository.save(publicacion);
            return ResponseEntity.ok(new MessageResponse("Borrado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/likes/{id}")
    public ResponseEntity<?> likes(@PathVariable long id, @RequestBody Integer id_usuario) {
        Publicacion publicacion = publicacionRepository.findById(id);
        Usuario usuario = usuarioRepository.findById(id_usuario);
        try {
            if(publicacion.getLikes().size()==0){
                publicacion.getLikes().add(usuario);
                publicacionRepository.save(publicacion);
                return ResponseEntity.ok(new MessageResponse("Modificado correctamente"));
            }
            for(Usuario u : publicacion.getLikes()) {
                if (usuario.equals(u)) {
                    publicacion.getLikes().remove(usuario);
                    publicacionRepository.save(publicacion);
                    break;
                } else {
                    publicacion.getLikes().add(usuario);
                    publicacionRepository.save(publicacion);
                }
            }
            return ResponseEntity.ok(new MessageResponse("Modificado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }
    }

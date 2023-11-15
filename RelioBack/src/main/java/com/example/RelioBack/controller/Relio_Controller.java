package com.example.RelioBack.controller;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.dto.AddPersonDTO;
import com.example.RelioBack.model.dto.RelioDTO;
import com.example.RelioBack.payload.response.MessageResponse;
import com.example.RelioBack.repository.FiestasRepository;
import com.example.RelioBack.repository.PublicacionRepository;
import com.example.RelioBack.repository.RelioRepository;
import com.example.RelioBack.repository.UsuarioRepository;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/relio")
public class Relio_Controller {

    @Autowired
    RelioRepository relioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FiestasRepository fiestasRepository;

    @Autowired
    PublicacionRepository publicacionRepository;
    @RequestMapping(method = RequestMethod.POST, value = "/create/{id}")
    public ResponseEntity<?> createRelio(@PathVariable long id, @RequestBody RelioDTO relioDto) {
        Relio relio = new Relio();
        Usuario usuario = usuarioRepository.findById(id);
        relio.setOcio(usuario);
        Usuario usuario1= usuarioRepository.findById(relioDto.getUsuario_emisor());
        relio.setUsuario_emisor(usuario1);
        relio.setDescripcion(relioDto.getDescripcion());
        relio.setStart(relioDto.getStart());
        relio.setPersonas(relioDto.getPersonas());
        relio.setFecha_publicacion(LocalDateTime.now());
        relio.setLleno(0);
        Fiestas fiestas = fiestasRepository.buscarFiesta(relioDto.getFiestas());
        relio.setFiestas(fiestas);
        relio.setMax_personas(relioDto.getMax_personas());

        try{
            relioRepository.save(relio);
            usuario.getRelio().add(relio);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok(new MessageResponse("Creado correctamente"));

        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPerson/{id}")
    public ResponseEntity<?> addPerson(@PathVariable long id, @RequestBody AddPersonDTO addPersonDTO) {
        Relio relio = relioRepository.findById(id);
        Set<Usuario> usuarios = relio.getUsuarios_receptores();
        Usuario usuario= usuarioRepository.findById(addPersonDTO.getUsuario_id());
        usuarios.add(usuario);
        relio.setUsuarios_receptores(usuarios);
        if(relio.getPersonas()+ addPersonDTO.getPersonas()< relio.getMax_personas()) {
            relio.setPersonas(relio.getPersonas() + addPersonDTO.getPersonas());
            relio.setLleno(1);
        }else{
            return ResponseEntity.ok(new MessageResponse("No hay sitio suficiente"));
        }
        try{
            relioRepository.addPerson(relio.getPersonas(),relio.getLleno(), relio.getId());
//            relioRepository.relio_receptores(relio.getId(), usuario.getId());
            return ResponseEntity.ok(new MessageResponse("Creado correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifyHourRelio/{id}")
    public ResponseEntity<?> modifyHourRelio(@PathVariable long id, @RequestBody RelioDTO fecha_inicio) {
        Relio relio = relioRepository.findById(id);
        if(fecha_inicio.getStart().isAfter(LocalDateTime.now())) {
            relio.setStart(fecha_inicio.getStart());
        }
        try{
            relioRepository.modifyHourRelio(relio.getStart(), relio.getId());
            return ResponseEntity.ok(new MessageResponse("Modificado correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarRelio/{id}")
    public ResponseEntity<?> deleteRelio(@PathVariable long id) {
        try {
            Relio relio = relioRepository.findById(id);
            Set<Relio> relios = relio.getUsuario_emisor().getRelio();
            for(Relio r : relios){
                if(r.getId()==id){
                    relio.getUsuario_emisor().getRelio().remove(r);
                }
                relioRepository.save(relio);
            }
            List<Publicacion> publicacions = publicacionRepository.findByIdRelio(id);
            for(Publicacion p : publicacions){
                publicacionRepository.delete(p);
            }
            relioRepository.delete(relio);
            return ResponseEntity.ok(new MessageResponse("Borrado correctamente"));
        }catch (Exception e){
            return ResponseEntity.ok(new MessageResponse("Ha habido un error"));
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public JsonObject allRelios() {
        List<Relio> relios = relioRepository.findAll();
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("todasRelios",relios.stream().
                sorted(Comparator.comparing(Relio::getStart)).collect(Collectors.toList()));
        return jsonObject;
    }


}

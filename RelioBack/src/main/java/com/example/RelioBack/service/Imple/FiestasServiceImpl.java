package com.example.RelioBack.service.Imple;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.repository.FiestasRepository;
import com.example.RelioBack.service.FiestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiestasServiceImpl implements FiestasService {

    @Autowired
    FiestasRepository fiestasRepository;
    @Override
    public void updateFiestas(Long id, Fiestas fiestas){
        Fiestas fiestas1 = fiestasRepository.buscarFiesta(id);
        if(fiestas.getDescripcion()==null){
            fiestas.setDescripcion(fiestas1.getDescripcion());
        }
        if(fiestas.getStart()==null){
            fiestas.setStart(fiestas1.getStart());
        }
        if(fiestas.getEnd()==null){
            fiestas.setEnd(fiestas1.getEnd());
        }
        if(fiestas.getUrl_foto()==null){
            fiestas.setUrl_foto(fiestas1.getUrl_foto());
        }
        if(fiestas.getPrecio()==null){
            fiestas.setPrecio(fiestas1.getPrecio());
        }
        fiestas.setUsuario(fiestas1.getUsuario());
        fiestasRepository.modifyFiesta(fiestas.getDescripcion(), fiestas.getStart(), fiestas.getEnd(),
                fiestas.getUrl_foto(),fiestas.getPrecio(),fiestas.getUsuario().getId());
//        fiestasRepository.save(fiestas);
    }
}

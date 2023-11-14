package com.example.RelioBack.repository;

import com.example.RelioBack.model.Comentarios;
import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{
    @Query(value = "select * from comentarios where id = :id", nativeQuery = true)
    Comentarios findById(long id);

}

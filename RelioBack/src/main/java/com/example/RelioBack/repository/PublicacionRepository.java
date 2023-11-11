package com.example.RelioBack.repository;

import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    @Query(value = "select * from publicacion where id = :id", nativeQuery = true)
    Publicacion findById(long id);

    @Modifying
    @Transactional
    @Query(value = "update publicacion c set c.descripcion = :descripcion where c.id = :id", nativeQuery = true)
    void modifyPublicacion(@Param("descripcion") String descripcion, @Param("id") Integer id);
}

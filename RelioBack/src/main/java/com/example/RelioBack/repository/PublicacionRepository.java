package com.example.RelioBack.repository;

import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import org.apache.poi.util.Removal;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    @Query(value = "select * from publicacion where id = :id", nativeQuery = true)
    Publicacion findById(long id);

    @Modifying
    @Transactional
    @Query(value = "update publicacion c set c.descripcion = :descripcion where c.id = :id", nativeQuery = true)
    void modifyPublicacion(@Param("descripcion") String descripcion, @Param("id") Integer id);

    @Query(value = "select * from publicacion where usuario_id = :id", nativeQuery = true)
    List<Publicacion> findByIdUser(long id);

    @Query(value = "select * from publicacion where relio = :id", nativeQuery = true)
    List<Publicacion> findByIdRelio(long id);

    @Query(value = "select * from publicacion where fiesta_id = :id", nativeQuery = true)
    List<Publicacion> findByIdFiesta(long id);

    @Removal
    @Query(value = "DELETE from publicacion where id = :id", nativeQuery = true)
    void deleteById1(long id);

    @Query(value = "select user_id from likes_publicacion where publicacion_id = :id", nativeQuery = true)
    List<Integer> existelike(long id);

}

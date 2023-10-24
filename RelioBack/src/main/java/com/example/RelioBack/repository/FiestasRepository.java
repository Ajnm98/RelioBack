package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Fiestas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FiestasRepository extends JpaRepository<Fiestas, Long> {
    @Query(value = "select * from fiestas where id = :id", nativeQuery = true)
    Fiestas buscarFiesta(long id);

    @Modifying
    @Transactional
    @Query(value = "update fiestas c set c.descripcion = :descripcion, c.fecha_inicio = :start, c.fecha_fin = :end,"
            + "c.url_foto = :url_foto, c.precio = :precio where c.ocio_id = :id", nativeQuery = true)
    void modifyFiesta(@Param("descripcion") String descripcion, @Param("start") LocalDateTime start,
                       @Param("end") LocalDateTime end,
                       @Param("url_foto") String url_foto, @Param("precio") Double precio,
                       @Param("id") Long id);

    @Query(value = "select * from fiestas where ocio_id = :id", nativeQuery = true)
    List<Fiestas> findAllByOcio_id(long id);

    @Query(value = "select * from fiestas where fecha_fin > :vigente", nativeQuery = true)
    List<Fiestas> findFiestasVigentes(LocalDateTime vigente);
}

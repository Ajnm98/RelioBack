package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Datos_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Datos_OcioRepository extends JpaRepository<Datos_Ocio, Long> {

    Datos_Ocio findDatosUsuariosByUsuario_Id(Long id);

    @Modifying
    @Transactional
    @Query(value = "update datos_ocio c set c.nombre = :nombre, c.pais = :pais, c.direccion = :direccion,"
            + "c.telefono = :telefono, c.url_icono = :url_icono, c.url_banner = :url_banner where c.usuario_id = :id", nativeQuery = true)
    void modifyUsuario(@Param("nombre") String nombre, @Param("pais") String pais,
                       @Param("direccion") String direccion,
                       @Param("telefono") Integer telefono, @Param("url_icono") String url_icono, @Param("url_banner") String url_banner,
                       @Param("id") Long id);


    @Query(value = "select * from datos_ocio where nombre LIKE %:usuario%", nativeQuery = true)
    List<Datos_Ocio> findByNombreBusqueda(String usuario);


}

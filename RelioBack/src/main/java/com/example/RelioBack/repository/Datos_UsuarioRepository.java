package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Repository
public interface Datos_UsuarioRepository extends JpaRepository<Datos_Usuario, Long> {

    Datos_Usuario findDatosUsuariosByUsuario_Id(Long id);

    @Query(value = "select * from datos_usuario where usuario_id = :usuario", nativeQuery = true)
    Datos_Usuario findById(long usuario);

    @Modifying
    @Transactional
    @Query(value = "update datos_usuario c set c.nombre = :nombre, c.bio = :bio, c.pais = :pais, c.direccion = :direccion,"
            + "c.genero = :genero, c.url_icono = :url_icono, c.url_banner = :url_banner where c.usuario_id = :id", nativeQuery = true)
    void modifyUsuario(@Param("nombre") String nombre, @Param("bio") String bio,
                                @Param("pais") String pais, @Param("direccion") String direccion,
                                @Param("genero") String genero, @Param("url_icono") String url_icono, @Param("url_banner") String url_banner,
                                @Param("id") Long id);


}

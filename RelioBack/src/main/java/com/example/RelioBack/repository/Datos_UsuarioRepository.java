package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Datos_UsuarioRepository extends JpaRepository<Datos_Usuario, Long> {

    Datos_Usuario findDatosUsuariosByUsuario_Id(Long id);

    @Query(value = "select * from datos_usuario where usuario_id = :usuario", nativeQuery = true)
    Datos_Usuario findById(long usuario);

    @Query(value = "", nativeQuery = true)
    Datos_Usuario modifyUsuario(Datos_Usuario datosUsuario);


}

package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Usuario;
import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
    @Query(value = "select * from usuarios where username = :username", nativeQuery = true)
    Usuario buscarPorUsername(String username);

    @Query(value = "select * from usuarios where id = :usuario", nativeQuery = true)
    Usuario findById(long usuario);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}

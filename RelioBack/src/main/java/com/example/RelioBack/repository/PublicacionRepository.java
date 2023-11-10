package com.example.RelioBack.repository;

import com.example.RelioBack.model.Publicacion;
import com.example.RelioBack.model.Relio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}

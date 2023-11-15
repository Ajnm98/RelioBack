package com.example.RelioBack.repository;

import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {


}

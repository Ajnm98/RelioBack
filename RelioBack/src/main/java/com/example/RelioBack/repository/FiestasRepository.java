package com.example.RelioBack.repository;

import com.example.RelioBack.model.Datos_Ocio;
import com.example.RelioBack.model.Fiestas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FiestasRepository extends JpaRepository<Fiestas, Long> {
    @Query(value = "select * from fiestas where id = :id", nativeQuery = true)
    Fiestas buscarFiesta(long id);

}

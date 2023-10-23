package com.example.RelioBack.repository;

import com.example.RelioBack.model.ERol;
import com.example.RelioBack.model.ETipo_Lugar;
import com.example.RelioBack.model.Rol;
import com.example.RelioBack.model.Tipo_Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Tipo_LugarRepository extends JpaRepository<Tipo_Lugar, Long> {
    Optional<Tipo_Lugar> findByName(ETipo_Lugar name);

}

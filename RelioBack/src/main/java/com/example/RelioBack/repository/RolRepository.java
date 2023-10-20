package com.example.RelioBack.repository;


import com.example.RelioBack.model.ERol;
import com.example.RelioBack.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(ERol name);
}

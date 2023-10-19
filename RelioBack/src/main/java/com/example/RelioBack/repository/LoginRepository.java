package com.example.RelioBack.repository;

import com.example.RelioBack.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findTopByEmail(String email);
}

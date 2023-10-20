package com.example.RelioBack.service;


import com.example.RelioBack.model.Usuario;
import com.example.RelioBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


}

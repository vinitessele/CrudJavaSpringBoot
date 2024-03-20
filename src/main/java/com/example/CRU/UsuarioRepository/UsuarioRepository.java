package com.example.CRU.UsuarioRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRU.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
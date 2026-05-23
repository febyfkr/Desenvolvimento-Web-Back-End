package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.projeto.entity.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {}

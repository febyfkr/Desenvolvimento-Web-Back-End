package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula.projeto.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {}

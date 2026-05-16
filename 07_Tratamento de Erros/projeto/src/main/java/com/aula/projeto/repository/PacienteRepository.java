package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.projeto.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}

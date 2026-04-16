package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula.projeto.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}

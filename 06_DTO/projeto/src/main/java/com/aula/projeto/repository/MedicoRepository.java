package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula.projeto.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {}

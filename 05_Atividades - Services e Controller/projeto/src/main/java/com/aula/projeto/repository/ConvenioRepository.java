package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula.projeto.model.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {}

package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula.projeto.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {}

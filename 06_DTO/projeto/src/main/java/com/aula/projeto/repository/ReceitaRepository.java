package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.projeto.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {}

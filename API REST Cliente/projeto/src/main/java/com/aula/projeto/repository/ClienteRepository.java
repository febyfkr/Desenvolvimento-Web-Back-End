package com.aula.projeto.repository;

import com.aula.projeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeStartingWith(String nome);
}

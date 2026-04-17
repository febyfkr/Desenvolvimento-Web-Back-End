package com.aula.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula.projeto.model.Cliente;
import com.aula.projeto.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // POST - cadastrar cliente
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // GET - listar todos
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    // DELETE - remover cliente
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "Cliente removido com sucesso!";
    }

    // GET - buscar por nome
    @GetMapping("/buscarPorNome")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return clienteRepository.findByNome(nome);
    }

    // GET - buscar por email
    @GetMapping("/buscarPorEmail")
    public Cliente buscarPorEmail(@RequestParam String email) {
        return clienteRepository.findByEmail(email);
    }
}

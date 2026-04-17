package com.aula.projeto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.projeto.model.Paciente;
import com.aula.projeto.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) { return service.salvar(paciente); }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente paciente) { return service.atualizar(id, paciente); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

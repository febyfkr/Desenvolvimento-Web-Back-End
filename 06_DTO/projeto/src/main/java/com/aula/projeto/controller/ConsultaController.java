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

import com.aula.projeto.dto.ConsultaRequestDTO;
import com.aula.projeto.dto.ConsultaResponseDTO;
import com.aula.projeto.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ConsultaResponseDTO salvar(@RequestBody @Valid ConsultaRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ConsultaResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}

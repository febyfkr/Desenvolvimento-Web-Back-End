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

import com.aula.projeto.dto.ReceitaRequestDTO;
import com.aula.projeto.dto.ReceitaResponseDTO;
import com.aula.projeto.service.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ReceitaResponseDTO salvar(@RequestBody @Valid ReceitaRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ReceitaResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ReceitaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ReceitaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}

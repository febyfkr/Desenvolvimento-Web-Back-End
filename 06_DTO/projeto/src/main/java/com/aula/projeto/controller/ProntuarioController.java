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

import com.aula.projeto.dto.ProntuarioRequestDTO;
import com.aula.projeto.dto.ProntuarioResponseDTO;
import com.aula.projeto.service.ProntuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ProntuarioResponseDTO salvar(@RequestBody @Valid ProntuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ProntuarioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProntuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProntuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}
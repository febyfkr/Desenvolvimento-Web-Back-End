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

import com.aula.projeto.dto.MedicoRequestDTO;
import com.aula.projeto.dto.MedicoResponseDTO;
import com.aula.projeto.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public MedicoResponseDTO salvar(@RequestBody @Valid MedicoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<MedicoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public MedicoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MedicoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}
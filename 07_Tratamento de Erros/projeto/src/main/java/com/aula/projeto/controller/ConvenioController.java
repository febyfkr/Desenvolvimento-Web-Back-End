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

import com.aula.projeto.dto.ConvenioRequestDTO;
import com.aula.projeto.dto.ConvenioResponseDTO;
import com.aula.projeto.service.ConvenioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {
    private final ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @PostMapping
    public ConvenioResponseDTO salvar(@RequestBody @Valid ConvenioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ConvenioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ConvenioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ConvenioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConvenioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}

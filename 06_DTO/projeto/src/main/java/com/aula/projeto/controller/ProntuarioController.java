package com.aula.projeto.controller;

import com.aula.projeto.entity.Prontuario;
import com.aula.projeto.service.ProntuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {
    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prontuario> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Prontuario buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) { return service.salvar(prontuario); }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario) { return service.atualizar(id, prontuario); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

package com.aula.projeto.controller;

import com.aula.projeto.model.Receita;
import com.aula.projeto.service.ReceitaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Receita> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Receita buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Receita salvar(@RequestBody Receita receita) { return service.salvar(receita); }

    @PutMapping("/{id}")
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita) { return service.atualizar(id, receita); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

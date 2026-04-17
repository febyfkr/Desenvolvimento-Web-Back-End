package com.aula.projeto.controller;

import com.aula.projeto.model.Consulta;
import com.aula.projeto.service.ConsultaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Consulta> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta) { return service.salvar(consulta); }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta consulta) { return service.atualizar(id, consulta); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

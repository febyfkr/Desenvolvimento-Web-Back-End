package com.aula.projeto.controller;

import com.aula.projeto.entity.Convenio;
import com.aula.projeto.service.ConvenioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {
    private final ConvenioService service;

    public ConvenioController(ConvenioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Convenio> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Convenio buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Convenio salvar(@RequestBody Convenio convenio) { return service.salvar(convenio); }

    @PutMapping("/{id}")
    public Convenio atualizar(@PathVariable Long id, @RequestBody Convenio convenio) { return service.atualizar(id, convenio); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

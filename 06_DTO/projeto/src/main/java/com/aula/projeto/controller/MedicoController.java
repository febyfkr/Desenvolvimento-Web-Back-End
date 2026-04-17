package com.aula.projeto.controller;

import com.aula.projeto.model.Medico;
import com.aula.projeto.service.MedicoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medico> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) { return service.buscarPorId(id).orElse(null); }

    @PostMapping
    public Medico salvar(@RequestBody Medico medico) { return service.salvar(medico); }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico medico) { return service.atualizar(id, medico); }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) { return service.excluir(id); }
}

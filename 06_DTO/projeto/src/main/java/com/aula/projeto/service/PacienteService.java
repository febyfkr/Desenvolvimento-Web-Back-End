package com.aula.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aula.projeto.entity.Paciente;
import com.aula.projeto.repository.PacienteRepository;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarTodos() { return repository.findAll(); }

    public Optional<Paciente> buscarPorId(Long id) { return repository.findById(id); }

    public Paciente salvar(Paciente paciente) { return repository.save(paciente); }

    public Paciente atualizar(Long id, Paciente paciente) {
        return repository.findById(id).map(p -> {
            p.setNome(paciente.getNome());
            p.setCpf(paciente.getCpf());
            p.setTelefone(paciente.getTelefone());
            return repository.save(p);
        }).orElse(null);
    }

    public boolean excluir(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

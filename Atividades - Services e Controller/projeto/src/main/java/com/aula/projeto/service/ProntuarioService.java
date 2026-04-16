package com.aula.projeto.service;

import com.aula.projeto.model.Prontuario;
import com.aula.projeto.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {
    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public List<Prontuario> listarTodos() { return repository.findAll(); }

    public Optional<Prontuario> buscarPorId(Long id) { return repository.findById(id); }

    public Prontuario salvar(Prontuario prontuario) { return repository.save(prontuario); }

    public Prontuario atualizar(Long id, Prontuario prontuario) {
        return repository.findById(id).map(p -> {
            p.setTipoSanguineo(prontuario.getTipoSanguineo());
            p.setAlergia(prontuario.getAlergia());
            p.setObservacoes(prontuario.getObservacoes());
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

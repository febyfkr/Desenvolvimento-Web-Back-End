package com.aula.projeto.service;

import com.aula.projeto.model.Receita;
import com.aula.projeto.repository.ReceitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    private final ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    public List<Receita> listarTodos() { return repository.findAll(); }

    public Optional<Receita> buscarPorId(Long id) { return repository.findById(id); }

    public Receita salvar(Receita receita) { return repository.save(receita); }

    public Receita atualizar(Long id, Receita receita) {
        return repository.findById(id).map(r -> {
            r.setMedicamento(receita.getMedicamento());
            r.setDosagem(receita.getDosagem());
            r.setDuracaoDias(receita.getDuracaoDias());
            return repository.save(r);
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

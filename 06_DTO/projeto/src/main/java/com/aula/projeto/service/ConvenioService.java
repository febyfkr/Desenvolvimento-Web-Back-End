package com.aula.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aula.projeto.entity.Convenio;
import com.aula.projeto.repository.ConvenioRepository;

@Service
public class ConvenioService {
    private final ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    public List<Convenio> listarTodos() { return repository.findAll(); }

    public Optional<Convenio> buscarPorId(Long id) { return repository.findById(id); }

    public Convenio salvar(Convenio convenio) { return repository.save(convenio); }

    public Convenio atualizar(Long id, Convenio convenio) {
        return repository.findById(id).map(c -> {
            c.setNome(convenio.getNome());
            c.setCnpj(convenio.getCnpj());
            return repository.save(c);
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

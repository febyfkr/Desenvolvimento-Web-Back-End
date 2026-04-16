package com.aula.projeto.service;

import com.aula.projeto.model.Medico;
import com.aula.projeto.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> listarTodos() { return repository.findAll(); }

    public Optional<Medico> buscarPorId(Long id) { return repository.findById(id); }

    public Medico salvar(Medico medico) { return repository.save(medico); }

    public Medico atualizar(Long id, Medico medico) {
        return repository.findById(id).map(m -> {
            m.setNome(medico.getNome());
            m.setEspecialidade(medico.getEspecialidade());
            m.setCrm(medico.getCrm());
            return repository.save(m);
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

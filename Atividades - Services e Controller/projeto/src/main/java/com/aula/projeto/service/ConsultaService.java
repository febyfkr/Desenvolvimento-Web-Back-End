package com.aula.projeto.service;

import com.aula.projeto.model.Consulta;
import com.aula.projeto.repository.ConsultaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> listarTodos() { return repository.findAll(); }

    public Optional<Consulta> buscarPorId(Long id) { return repository.findById(id); }

    public Consulta salvar(Consulta consulta) { return repository.save(consulta); }

    public Consulta atualizar(Long id, Consulta consulta) {
        return repository.findById(id).map(c -> {
            c.setDataHora(consulta.getDataHora());
            c.setMotivo(consulta.getMotivo());
            c.setValor(consulta.getValor());
            c.setPaciente(consulta.getPaciente());
            c.setMedico(consulta.getMedico());
            c.setConvenio(consulta.getConvenio());
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

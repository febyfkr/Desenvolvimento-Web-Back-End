package com.aula.projeto.service;

import com.aula.projeto.dto.ConsultaRequestDTO;
import com.aula.projeto.dto.ConsultaResponseDTO;
import com.aula.projeto.model.Consulta;
import com.aula.projeto.repository.ConsultaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.aula.projeto.entity.Consulta;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    private Consulta toEntity(ConsultaRequestDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());
        // aqui você buscaria paciente, médico e convênio pelos IDs
        return consulta;
    }

    private ConsultaResponseDTO toDTO(Consulta consulta) {
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .motivo(consulta.getMotivo())
                .valor(consulta.getValor())
                .pacienteId(consulta.getPaciente() != null ? consulta.getPaciente().getId() : null)
                .medicoId(consulta.getMedico() != null ? consulta.getMedico().getId() : null)
                .convenioId(consulta.getConvenio() != null ? consulta.getConvenio().getId() : null)
                .receitaId(consulta.getReceita() != null ? consulta.getReceita().getId() : null)
                .build();
    }

    public ConsultaResponseDTO salvar(ConsultaRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ConsultaResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setValor(dto.getValor());
        return toDTO(repository.save(consulta));
    }

    public String excluir(Long id) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        repository.delete(consulta);
        return "Consulta excluída com sucesso!";
    }
}
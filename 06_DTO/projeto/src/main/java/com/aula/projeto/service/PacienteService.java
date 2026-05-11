package com.aula.projeto.service;

import com.aula.projeto.dto.PacienteRequestDTO;
import com.aula.projeto.dto.PacienteResponseDTO;
import com.aula.projeto.model.Paciente;
import com.aula.projeto.repository.PacienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.aula.projeto.entity.Paciente;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    private Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        return paciente;
    }

    private PacienteResponseDTO toDTO(Paciente paciente) {
        return PacienteResponseDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .telefone(paciente.getTelefone())
                .build();
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente salvo = repository.save(toEntity(dto));
        return toDTO(salvo);
    }

    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        return toDTO(repository.save(paciente));
    }

    public String excluir(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        repository.delete(paciente);
        return "Paciente excluído com sucesso!";
    }
}
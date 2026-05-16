package com.aula.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aula.projeto.dto.MedicoRequestDTO;
import com.aula.projeto.dto.MedicoResponseDTO;
import com.aula.projeto.entity.Medico;
import com.aula.projeto.repository.MedicoRepository;

@Service
public class MedicoService {
    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    private Medico toEntity(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        return medico;
    }

    private MedicoResponseDTO toDTO(Medico medico) {
        return MedicoResponseDTO.builder()
                .id(medico.getId())
                .nome(medico.getNome())
                .especialidade(medico.getEspecialidade())
                .crm(medico.getCrm())
                .build();
    }

    public MedicoResponseDTO salvar(MedicoRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<MedicoResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public MedicoResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        return toDTO(repository.save(medico));
    }

    public String excluir(Long id) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        repository.delete(medico);
        return "Médico excluído com sucesso!";
    }
}
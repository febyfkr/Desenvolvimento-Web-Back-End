package com.aula.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aula.projeto.config.RegraNegocioException;
import com.aula.projeto.dto.ProntuarioRequestDTO;
import com.aula.projeto.dto.ProntuarioResponseDTO;
import com.aula.projeto.entity.Prontuario;
import com.aula.projeto.repository.ProntuarioRepository;

@Service
public class ProntuarioService {
    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    private Prontuario toEntity(ProntuarioRequestDTO dto) {
        Prontuario prontuario = new Prontuario();
        prontuario.setTipoSanguineo(dto.getTipoSanguineo());
        prontuario.setAlergia(dto.getAlergia());
        prontuario.setObservacoes(dto.getObservacoes());
        return prontuario;
    }

    private ProntuarioResponseDTO toDTO(Prontuario prontuario) {
        return ProntuarioResponseDTO.builder()
                .id(prontuario.getId())
                .tipoSanguineo(prontuario.getTipoSanguineo())
                .alergia(prontuario.getAlergia())
                .observacoes(prontuario.getObservacoes())
                .pacienteId(prontuario.getPaciente() != null ? prontuario.getPaciente().getId() : null)
                .build();
    }

    public ProntuarioResponseDTO salvar(ProntuarioRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ProntuarioResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProntuarioResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado"));
    }

    public ProntuarioResponseDTO atualizar(Long id, ProntuarioRequestDTO dto) {
        Prontuario prontuario = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado"));
        prontuario.setTipoSanguineo(dto.getTipoSanguineo());
        prontuario.setAlergia(dto.getAlergia());
        prontuario.setObservacoes(dto.getObservacoes());
        return toDTO(repository.save(prontuario));
    }

    public String excluir(Long id) {
        Prontuario prontuario = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado"));
        repository.delete(prontuario);
        return "Prontuário excluído com sucesso!";
    }

}
package com.aula.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aula.projeto.config.RegraNegocioException;
import com.aula.projeto.dto.ReceitaRequestDTO;
import com.aula.projeto.dto.ReceitaResponseDTO;
import com.aula.projeto.entity.Receita;
import com.aula.projeto.repository.ReceitaRepository;

@Service
public class ReceitaService {
    private final ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    private Receita toEntity(ReceitaRequestDTO dto) {
        Receita receita = new Receita();
        receita.setMedicamento(dto.getMedicamento());
        receita.setDosagem(dto.getDosagem());
        receita.setDuracaoDias(dto.getDuracaoDias());
        return receita;
    }

    private ReceitaResponseDTO toDTO(Receita receita) {
        return ReceitaResponseDTO.builder()
                .id(receita.getId())
                .medicamento(receita.getMedicamento())
                .dosagem(receita.getDosagem())
                .duracaoDias(receita.getDuracaoDias())
                .consultaId(receita.getConsulta() != null ? receita.getConsulta().getId() : null)
                .build();
    }

    public ReceitaResponseDTO salvar(ReceitaRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ReceitaResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ReceitaResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
    }

    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto) {
        Receita receita = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        receita.setMedicamento(dto.getMedicamento());
        receita.setDosagem(dto.getDosagem());
        receita.setDuracaoDias(dto.getDuracaoDias());
        return toDTO(repository.save(receita));
    }

    public String excluir(Long id) {
        Receita receita = repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Receita não encontrada"));
        repository.delete(receita);
        return "Receita excluída com sucesso!";
    }

}
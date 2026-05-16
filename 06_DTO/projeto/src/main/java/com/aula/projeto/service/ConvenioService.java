package com.aula.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aula.projeto.dto.ConvenioRequestDTO;
import com.aula.projeto.dto.ConvenioResponseDTO;
import com.aula.projeto.entity.Convenio;
import com.aula.projeto.repository.ConvenioRepository;

@Service
public class ConvenioService {
    private final ConvenioRepository repository;

    public ConvenioService(ConvenioRepository repository) {
        this.repository = repository;
    }

    private Convenio toEntity(ConvenioRequestDTO dto) {
        Convenio convenio = new Convenio();
        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());
        return convenio;
    }

    private ConvenioResponseDTO toDTO(Convenio convenio) {
        return ConvenioResponseDTO.builder()
                .id(convenio.getId())
                .nome(convenio.getNome())
                .cnpj(convenio.getCnpj())
                .build();
    }

    public ConvenioResponseDTO salvar(ConvenioRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ConvenioResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ConvenioResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado"));
    }

    public ConvenioResponseDTO atualizar(Long id, ConvenioRequestDTO dto) {
        Convenio convenio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado"));
        convenio.setNome(dto.getNome());
        convenio.setCnpj(dto.getCnpj());
        return toDTO(repository.save(convenio));
    }

    public String excluir(Long id) {
        Convenio convenio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado"));
        repository.delete(convenio);
        return "Convênio excluído com sucesso!";
    }
}
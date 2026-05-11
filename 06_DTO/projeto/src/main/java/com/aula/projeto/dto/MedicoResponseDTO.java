package com.aula.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String especialidade;
    private String crm;
}
package com.aula.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProntuarioResponseDTO {
    private Long id;
    private String tipoSanguineo;
    private String alergia;
    private String observacoes;
    private Long pacienteId;
}
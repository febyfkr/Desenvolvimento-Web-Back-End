package com.aula.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaResponseDTO {
    private Long id;
    private String medicamento;
    private String dosagem;
    private Integer duracaoDias;

    private Long consultaId;
}
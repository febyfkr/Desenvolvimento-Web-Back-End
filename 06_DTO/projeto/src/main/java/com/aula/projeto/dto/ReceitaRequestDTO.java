package com.aula.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaRequestDTO {
    @NotBlank(message = "Medicamento é obrigatório")
    private String medicamento;

    @NotBlank(message = "Dosagem é obrigatória")
    private String dosagem;

    @NotNull(message = "Duração em dias é obrigatória")
    private Integer duracaoDias;

    @NotNull(message = "Consulta é obrigatória")
    private Long consultaId;
}
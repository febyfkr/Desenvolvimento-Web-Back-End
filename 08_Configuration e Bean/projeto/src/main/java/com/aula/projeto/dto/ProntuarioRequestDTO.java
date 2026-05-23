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
public class ProntuarioRequestDTO {
    @NotBlank(message = "Tipo sanguíneo é obrigatório")
    private String tipoSanguineo;

    private String alergia;
    private String observacoes;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;
}
package com.aula.projeto.dto;

import java.time.LocalDateTime;

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
public class ConsultaRequestDTO {
    @NotNull(message = "Data e hora são obrigatórios")
    private LocalDateTime dataHora;

    @NotBlank(message = "Motivo é obrigatório")
    private String motivo;

    @NotNull(message = "Valor é obrigatório")
    private Double valor;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "Médico é obrigatório")
    private Long medicoId;

    @NotNull(message = "Convênio é obrigatório")
    private Long convenioId;
}
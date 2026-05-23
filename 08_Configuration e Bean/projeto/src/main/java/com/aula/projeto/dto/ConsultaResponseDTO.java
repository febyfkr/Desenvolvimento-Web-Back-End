package com.aula.projeto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String motivo;
    private Double valor;

    // IDs relacionados
    private Long pacienteId;
    private Long medicoId;
    private Long convenioId;
    private Long receitaId;
}
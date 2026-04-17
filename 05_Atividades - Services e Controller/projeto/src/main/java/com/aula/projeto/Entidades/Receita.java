package com.aula.projeto.Entidades;

import jakarta.persistence.*;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicamento;
    private String dosagem;
    private int duracaoDias;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
}
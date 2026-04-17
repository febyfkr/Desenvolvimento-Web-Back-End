package com.aula.projeto.Entidades;

import jakarta.persistence.*;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especialidade;
    private String crm;

    @OneToMany(mappedBy = "medico")
    private java.util.List<Consulta> consultas;
}
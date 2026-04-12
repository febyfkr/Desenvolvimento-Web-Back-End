package com.aula.projeto.Entidades;

import jakarta.persistence.*;

@Entity
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;

    @OneToMany(mappedBy = "convenio")
    private java.util.List<Consulta> consultas;
}
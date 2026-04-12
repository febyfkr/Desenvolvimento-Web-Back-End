package com.aula.projeto.Entidades;

import jakarta.persistence.*;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente")
    private java.util.List<Consulta> consultas;
}

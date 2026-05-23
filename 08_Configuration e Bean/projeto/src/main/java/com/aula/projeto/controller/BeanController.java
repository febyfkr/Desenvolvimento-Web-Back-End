package com.aula.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.projeto.entity.Paciente;

@RestController
@RequestMapping("/bean")
public class BeanController {

    private final Paciente pacienteBean;

    @Autowired
    public BeanController(Paciente pacienteBean) {
        this.pacienteBean = pacienteBean;
    }

    @GetMapping
    public Paciente getPacienteCompleto() {
        return pacienteBean;
    }
}

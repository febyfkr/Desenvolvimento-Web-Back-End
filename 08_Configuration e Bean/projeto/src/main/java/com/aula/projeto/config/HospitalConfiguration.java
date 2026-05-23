package com.aula.projeto.config;

import com.aula.projeto.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class HospitalConfiguration {

    @Bean
    public Paciente pacienteBean() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("João da Silva");
        paciente.setCpf("12345678900");
        paciente.setTelefone("11999999999");

        // Prontuário
        Prontuario prontuario = new Prontuario();
        prontuario.setId(1L);
        prontuario.setTipoSanguineo("O+");
        prontuario.setAlergia("Dipirona");
        prontuario.setObservacoes("Paciente com histórico de hipertensão");
        prontuario.setPaciente(paciente);
        paciente.setProntuario(prontuario);

        // Convênio
        Convenio convenio = new Convenio();
        convenio.setId(1L);
        convenio.setNome("Unimed");
        convenio.setCnpj("12345678000199");

        // Médico
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNome("Dra. Maria Oliveira");
        medico.setEspecialidade("Cardiologia");
        medico.setCrm("CRM-SP-12345");

        // Consulta
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        consulta.setDataHora(LocalDateTime.now());
        consulta.setMotivo("Check-up anual");
        consulta.setValor(250.0);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setConvenio(convenio);

        // Receita
        Receita receita = new Receita();
        receita.setId(1L);
        receita.setMedicamento("Losartana");
        receita.setDosagem("50mg");
        receita.setDuracaoDias(30);
        receita.setConsulta(consulta);
        consulta.setReceita(receita);

        paciente.setConsultas(List.of(consulta));

        return paciente;
    }
}
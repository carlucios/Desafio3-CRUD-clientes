package com.devsuperior.desafio3.dto;

import com.devsuperior.desafio3.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getName();
        income = cliente.getIncome();
        birthDate = cliente.getBirthDate();
        children = cliente.getChildren();
    }

}

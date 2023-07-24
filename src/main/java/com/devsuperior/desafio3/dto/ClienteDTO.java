package com.devsuperior.desafio3.dto;

import com.devsuperior.desafio3.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    @NotBlank(message = "O campo nome é de preenchimento obrigatório")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser futura")
    private LocalDate birthDate;
    private Integer children;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getCpf();
        income = cliente.getIncome();
        birthDate = cliente.getBirthDate();
        children = cliente.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}

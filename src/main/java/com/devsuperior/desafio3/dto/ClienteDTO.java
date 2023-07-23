package com.devsuperior.desafio3.dto;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;
}

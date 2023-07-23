package com.devsuperior.desafio3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public Cliente() {
    }

    public Cliente(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cliente setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Double getIncome() {
        return income;
    }

    public Cliente setIncome(Double income) {
        this.income = income;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Cliente setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Integer getChildren() {
        return children;
    }

    public Cliente setChildren(Integer children) {
        this.children = children;
        return this;
    }
}

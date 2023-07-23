package com.devsuperior.desafio3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(name, cliente.name) && Objects.equals(cpf, cliente.cpf) && Objects.equals(income, cliente.income) && Objects.equals(birthDate, cliente.birthDate) && Objects.equals(children, cliente.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, income, birthDate, children);
    }
}

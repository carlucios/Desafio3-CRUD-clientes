package com.devsuperior.desafio3.repositories;

import com.devsuperior.desafio3.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepositoy extends JpaRepository<Cliente, Long> {

}

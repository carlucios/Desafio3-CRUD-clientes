package com.devsuperior.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.desafio3.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


}

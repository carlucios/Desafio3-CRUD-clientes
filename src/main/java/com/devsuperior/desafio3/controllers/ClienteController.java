package com.devsuperior.desafio3.controllers;

import com.devsuperior.desafio3.dto.ClienteDTO;
import com.devsuperior.desafio3.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> add(@RequestBody ClienteDTO clienteDTO){
        clienteDTO = service.add(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @GetMapping
    public Page<ClienteDTO> findAll(Pageable pageable) {
        Page<ClienteDTO> result = service.findAll(pageable);
        return result;
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        ClienteDTO clienteDTO = service.findById(id);
        return clienteDTO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id) {
        clienteDTO = service.update(clienteDTO, id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

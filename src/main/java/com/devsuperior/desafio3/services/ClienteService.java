package com.devsuperior.desafio3.services;

import com.devsuperior.desafio3.dto.ClienteDTO;
import com.devsuperior.desafio3.entities.Cliente;
import com.devsuperior.desafio3.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.devsuperior.desafio3.repositories.ClienteRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) {
        Page<Cliente> result = repository.findAll(pageable);
        return result.map(x -> new ClienteDTO(x));
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado"));
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Transactional
    public ClienteDTO add(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        return getClienteDTOSavingCliente(clienteDTO, cliente);
    }

    @Transactional
    public ClienteDTO update(ClienteDTO clienteDTO, Long id) {
        try {
            Cliente cliente = repository.getReferenceById(id);
            return getClienteDTOSavingCliente(clienteDTO, cliente);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }

    private ClienteDTO getClienteDTOSavingCliente(ClienteDTO clienteDTO, Cliente cliente) {
        cliente.setName(clienteDTO.getName());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setIncome(clienteDTO.getIncome());
        cliente.setBirthDate(clienteDTO.getBirthDate());
        cliente.setChildren(clienteDTO.getChildren());
        cliente = repository.save(cliente);
        clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }
}

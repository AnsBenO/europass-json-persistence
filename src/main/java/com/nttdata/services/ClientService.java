package com.nttdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nttdata.entities.Client;
import com.nttdata.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            return null;
        }
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client clientToDelete = optionalClient.get();
            clientRepository.delete(clientToDelete);
        }
    }

}

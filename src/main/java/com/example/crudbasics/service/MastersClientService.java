package com.example.crudbasics.service;

import com.example.crudbasics.dto.ClientDto;
import com.example.crudbasics.models.Client;

import java.util.List;
import java.util.Optional;

public interface MastersClientService {
    Client createClient(ClientDto clientDto);
    Optional<Client> getClientById(String id);
    List<Client> getAllClients();
    Client updateClientById(String id, ClientDto clientDto); // Updated method name
    void deleteClientById(String id); // Updated method name
}

package com.example.crudbasics.service.Implementation;

import com.example.crudbasics.dto.ClientDto;
import com.example.crudbasics.models.Client;
import com.example.crudbasics.repository.MastersClientRepository;
import com.example.crudbasics.service.MastersClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MastersClientServiceImpl implements MastersClientService {

    private final MastersClientRepository mastersClientRepository;

    @Override
    public Client createClient(ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return mastersClientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientById(String id) {
        return mastersClientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return mastersClientRepository.findAll();
    }

    @Override
    public Client updateClientById(String id, ClientDto clientDto) {
        Client existingClient = getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        BeanUtils.copyProperties(clientDto, existingClient, "id");
        return mastersClientRepository.save(existingClient);
    }

    @Override
    public void deleteClientById(String id) {
        mastersClientRepository.deleteById(id);
    }
}

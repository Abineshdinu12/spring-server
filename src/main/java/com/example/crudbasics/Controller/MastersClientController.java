package com.example.crudbasics.Controller;

import com.example.crudbasics.dto.ClientDto;
import com.example.crudbasics.models.Client;
import com.example.crudbasics.service.MastersClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class MastersClientController {

    private final MastersClientService mastersClientService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createClient(@RequestBody ClientDto clientDto) {
        try {
            Client client = mastersClientService.createClient(clientDto);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client created successfully");
            response.put("clientId", client.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to create client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = mastersClientService.getAllClients();
        if (clients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clients);
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getClientById(@PathVariable String id) {
        Optional<Client> client = mastersClientService.getClientById(id);
        Map<String, Object> response = new HashMap<>();
        if (client.isPresent()) {
            response.put("message", "Client retrieved successfully");
            response.put("client", client.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Client not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateClientById(@PathVariable String id, @RequestBody ClientDto clientDto) {
        try {
            Client updatedClient = mastersClientService.updateClientById(id, clientDto);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client updated successfully");
            response.put("clientId", updatedClient.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to update client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteClientById(@PathVariable String id) {
        try {
            mastersClientService.deleteClientById(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to delete client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}

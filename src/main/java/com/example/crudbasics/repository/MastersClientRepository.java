package com.example.crudbasics.repository;

import com.example.crudbasics.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MastersClientRepository extends MongoRepository<Client, String> {
}

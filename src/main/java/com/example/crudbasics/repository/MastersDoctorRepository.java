package com.example.crudbasics.repository;

import com.example.crudbasics.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MastersDoctorRepository extends MongoRepository <Doctor, String> {
}

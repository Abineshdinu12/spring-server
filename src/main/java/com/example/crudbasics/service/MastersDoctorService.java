package com.example.crudbasics.service;

import com.example.crudbasics.dto.DoctorDto;
import com.example.crudbasics.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface MastersDoctorService {
    Doctor createDoctor(DoctorDto DoctorDto);
    Optional<Doctor> getDoctorById(String id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctorById(String id, DoctorDto DoctorDto); // Updated method name
    void deleteDoctorById(String id); // Updated method name
}

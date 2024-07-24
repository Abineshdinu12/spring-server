package com.example.crudbasics.service.Implementation;

import com.example.crudbasics.dto.DoctorDto;
import com.example.crudbasics.models.Doctor;
import com.example.crudbasics.repository.MastersDoctorRepository;
import com.example.crudbasics.service.MastersDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MastersDoctorServiceImpl implements MastersDoctorService {

    private final MastersDoctorRepository mastersDoctorRepository;

    @Override
    public Doctor createDoctor(DoctorDto DoctorDto) {
        Doctor Doctor = new Doctor();
        BeanUtils.copyProperties(DoctorDto, Doctor);
        return mastersDoctorRepository.save(Doctor);
    }

    @Override
    public Optional<Doctor> getDoctorById(String id) {
        return mastersDoctorRepository.findById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return mastersDoctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctorById(String id, DoctorDto DoctorDto) {
        Doctor existingDoctor = getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        BeanUtils.copyProperties(DoctorDto, existingDoctor, "id");
        return mastersDoctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctorById(String id) {
        mastersDoctorRepository.deleteById(id);
    }
}

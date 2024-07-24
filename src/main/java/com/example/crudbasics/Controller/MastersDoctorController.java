package com.example.crudbasics.Controller;

import com.example.crudbasics.dto.DoctorDto;
import com.example.crudbasics.models.Doctor;
import com.example.crudbasics.service.MastersDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class MastersDoctorController {

    private final MastersDoctorService mastersDoctorService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createDoctor(@RequestBody DoctorDto DoctorDto) {
        try {
            Doctor Doctor = mastersDoctorService.createDoctor(DoctorDto);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Doctor created successfully");
            response.put("DoctorId", Doctor.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to create Doctor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> Doctors = mastersDoctorService.getAllDoctors();
        if (Doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Doctors);
        }
        return ResponseEntity.ok(Doctors);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getDoctorById(@PathVariable String id) {
        Optional<Doctor> Doctor = mastersDoctorService.getDoctorById(id);
        Map<String, Object> response = new HashMap<>();
        if (Doctor.isPresent()) {
            response.put("message", "Doctor retrieved successfully");
            response.put("Doctor", Doctor.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Doctor not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDoctorById(@PathVariable String id, @RequestBody DoctorDto DoctorDto) {
        try {
            Doctor updatedDoctor = mastersDoctorService.updateDoctorById(id, DoctorDto);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Doctor updated successfully");
            response.put("DoctorId", updatedDoctor.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to update Doctor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDoctorById(@PathVariable String id) {
        try {
            mastersDoctorService.deleteDoctorById(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Doctor deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to delete Doctor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}

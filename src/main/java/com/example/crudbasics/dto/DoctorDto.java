package com.example.crudbasics.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private String id; // Changed to String
    private String name; // Changed to camelCase
    private String doctorId;
    private String license;
    private String webLicense;
    private String speciality;
    private String emailId;
    private String mobileNo;
}

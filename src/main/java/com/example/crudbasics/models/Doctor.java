package com.example.crudbasics.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "MastersDoctor")

public class Doctor {
    @Id
    private String id;
    private String name;
    private String doctorId;
    private String License;
    private String webLicense;
    private String Speciality;
    private String emailId;
    private String mobileNo;
}

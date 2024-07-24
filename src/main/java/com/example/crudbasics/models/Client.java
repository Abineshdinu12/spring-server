package com.example.crudbasics.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clients") // Updated collection name to match model
public class Client {
    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String companyFileName;
    private String companyLicenseNo;
}

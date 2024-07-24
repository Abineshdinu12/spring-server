package com.example.crudbasics.dto;

import lombok.Data;

@Data
public class ClientDto {
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String companyFileName;
    private String companyLicenseNo;
}

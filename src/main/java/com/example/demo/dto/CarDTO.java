package com.example.demo.dto;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String model;
    private int year;
    private String color;
    private Double km;
    private Double price;
    private String brand;
}

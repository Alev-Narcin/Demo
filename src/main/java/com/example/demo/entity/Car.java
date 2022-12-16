package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private int year;
    private String color;
    private Double km;
    private Double price;
    private String brand;
}

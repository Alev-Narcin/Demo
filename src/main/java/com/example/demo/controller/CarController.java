package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable("id") Long id) {
        Optional<CarDTO> car = carService.getCar(id);

        if (car.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(car.get());
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(carDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

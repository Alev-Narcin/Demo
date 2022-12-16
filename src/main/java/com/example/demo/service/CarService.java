package com.example.demo.service;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCars() {
//        carRepository.findAll().stream().map(carMapper::toDto).collect(Collectors.toList());
//        carRepository.findAll().stream().map(car -> carMapper.toDto(car)).collect(Collectors.toList());
        return carMapper.toDto(carRepository.findAll());
    }

//          public CarDTO getCar(Long id) {
//        Optional<Car> optionalCar = carRepository.findById(id);
//
//        return optionalCar.map(carMapper::toDto).orElse(null);
//    }

    public Optional<CarDTO> getCar(Long id) {
        return carRepository.findById(id).map(carMapper::toDto);
    }

    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);

        return carMapper.toDto(carRepository.save(car));
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @PostConstruct
    public void addCar() {
        CarDTO carDTO = new CarDTO();

        carDTO.setBrand("Renault");
        carDTO.setColor("red");
        carDTO.setModel("Clio");
        carDTO.setKm(15000.0);
        carDTO.setPrice(550000.0);
        carDTO.setYear(2022);

        saveCar(carDTO);
    }
}

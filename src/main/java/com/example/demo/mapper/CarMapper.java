package com.example.demo.mapper;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car toEntity(CarDTO carDTO);

    CarDTO toDto(Car car);

    List<Car> toEntity(List<CarDTO> carDTOS);

    List<CarDTO> toDto(List<Car> cars);
}

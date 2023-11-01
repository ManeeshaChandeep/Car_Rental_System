package spring.service;

import spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar();

    void saveCar(CarDTO carDTO);

    CarDTO getCar(String id);

    List<CarDTO> getAllCars();
}

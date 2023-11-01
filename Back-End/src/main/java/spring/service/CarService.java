package spring.service;

import spring.dto.CarDTO;

public interface CarService {
    void saveCar();

    void saveCar(CarDTO carDTO);
}

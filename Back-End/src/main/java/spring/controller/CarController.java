package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.CarDTO;
import spring.service.CarService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/save")
    public ResponseUtil saveCar(CarDTO dto) {
        carService.saveCar(dto);
        return new ResponseUtil("OK", "Car Saved", dto);
    }


    @GetMapping("/getall")
    public ResponseUtil getAllCars() {
        return new ResponseUtil("", "", carService.getAllCars());
    }

    @GetMapping("/GetOB")
    public ResponseUtil getCar(String id) {
        return new ResponseUtil("", "", carService.getCar(id));
    }
}

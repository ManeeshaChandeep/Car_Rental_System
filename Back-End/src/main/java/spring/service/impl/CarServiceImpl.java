package spring.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dto.CarDTO;
import spring.entity.Car;
import spring.repo.CarRepo;
import spring.service.CarService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{
@Autowired
    CarRepo carRepo;
@Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO carDTO){carRepo.save(mapper.map(carDTO, Car.class));}

    @Override
    public CarDTO getCar(String registernumber){
        return  mapper.map(carRepo.findById(registernumber),CarDTO.class);
    }

    @Override
    public List<CarDTO> getAllCars(){
        return mapper.map(carRepo.findAll(), new TypeToken<List<CarDTO>>() {}.getType());
    }

}

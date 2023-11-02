package spring.service.impl;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dto.AdminDTO;
import spring.dto.DriverDTO;
import spring.entity.Driver;
import spring.repo.DriverRepo;
import spring.service.DriverService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImple implements DriverService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO){
        driverRepo.save(mapper.map(driverDTO, Driver.class));
    }
    @Override
    public DriverDTO getDriver(String id){
        return mapper.map(driverRepo.findById(id),DriverDTO.class);
    }
    @Override
    public List<AdminDTO> getAllDrivers(){
        return  mapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>() {}.getType());
    }

}

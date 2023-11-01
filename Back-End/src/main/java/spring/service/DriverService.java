package spring.service;

import spring.dto.AdminDTO;
import spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);

    DriverDTO getDriver(String id);

    List<AdminDTO> getAllDrivers();
}

package spring.service;

import spring.dto.AdminDTO;
import spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    List<AdminDTO> getAllCustomers();
}

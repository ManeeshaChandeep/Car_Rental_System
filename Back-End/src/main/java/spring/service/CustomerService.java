package spring.service;

import spring.dto.CustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);
}

package spring.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dto.AdminDTO;
import spring.dto.CustomerDTO;
import spring.entity.Customer;
import spring.repo.CustomerRepo;
import spring.service.CustomerService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO){
        customerRepo.save(mapper.map(customerDTO, Customer.class));
    }
    @Override
    public  CustomerDTO getCustomer(String id){
        return mapper.map(customerRepo.findById(id),CustomerDTO.class);
    }
    @Override
    public List<AdminDTO> getAllCustomers(){
     return mapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>() {}.getType());
    }
}

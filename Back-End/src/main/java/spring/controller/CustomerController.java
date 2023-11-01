package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.CustomerDTO;
import spring.service.CarService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/customer")
@CrossOrigin

public class CustomerController {
@Autowired
    CarService customerService;
@PostMapping("/save")
    public ResponseUtil saveCustomer(CustomerDTO dto){
    return new ResponseUtil("OK","Customer Saved",dto);
}

@GetMapping("/getall")
    public ResponseUtil getAllCustomers(){
    return new ResponseUtil("","",customerService.get);
}

@GetMapping("/GetOB")
    public ResponseUtil getCustomer(String id){
    return new ResponseUtil("","",customerService.getCustomer(id));
}
}

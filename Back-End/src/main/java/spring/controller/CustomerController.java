package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.CustomerDTO;
import spring.service.CustomerService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/customer")
@CrossOrigin

public class CustomerController {
@Autowired
CustomerService customerService;
@PostMapping("/save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto){
    customerService.saveCustomer(dto);
    return new ResponseUtil("OK","Customer Saved",dto);
}

@PutMapping("/update")
public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
    customerService.saveCustomer(dto);
    return new ResponseUtil("OK","Customer Updated",dto);
}

@GetMapping("/getall")
    public ResponseUtil getAllCustomers(){
    return new ResponseUtil("","",customerService.getAllCustomers());
}

@GetMapping("/GetOB")
    public ResponseUtil getCustomer(String id){
    return new ResponseUtil("","",customerService.getCustomer(id));
}
}

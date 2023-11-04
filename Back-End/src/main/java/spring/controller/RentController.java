package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.RentDTO;
import spring.service.RentService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentService service;

    @PostMapping("/save")
    public ResponseUtil saveRent(@RequestBody RentDTO dto){
        System.out.println(dto);
        service.saveRent(dto);
        return new ResponseUtil("","",dto);
    }
}

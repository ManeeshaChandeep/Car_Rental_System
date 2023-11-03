package spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.DriverDTO;
import spring.service.DriverService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;


    @PostMapping("/save")
    public ResponseUtil saveDriver(@RequestBody DriverDTO dto) {
        System.out.println(dto);
       driverService.saveDriver(dto);
        return new ResponseUtil("OK", "Driver Saved", dto);
    }

    @PutMapping("/update")
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        driverService.saveDriver(dto);
        return new ResponseUtil("OK","Driver Updated",dto);
    }


    @GetMapping("/getall")
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil("", "",driverService.getAllDrivers());
    }

    @GetMapping("/GetOB")
    public ResponseUtil getDriver(String id) {
        return new ResponseUtil("", "", getDriver(id));
    }

}

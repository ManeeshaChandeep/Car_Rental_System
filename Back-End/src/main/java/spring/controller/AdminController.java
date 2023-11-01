package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.AdminDTO;
import spring.service.AdminService;
import spring.util.ResponseUtil;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/save")
    public ResponseUtil saveAdmin(AdminDTO dto){
        adminService.saveAdmin(dto);
        return new ResponseUtil("OK","Admin saved",dto);
    }
    @GetMapping("/getall")
    public ResponseUtil getAllAdmins(){
        return new ResponseUtil("","",adminService.getAllAdmins());
    }

    @GetMapping("/GetOB")
    public ResponseUtil getAdmin(String id){
        return new ResponseUtil("","",adminService.getAdmin(id));
    }
}

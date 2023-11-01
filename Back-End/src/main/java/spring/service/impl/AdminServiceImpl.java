package spring.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dto.AdminDTO;
import spring.entity.Admin;
import spring.repo.AdminRepo;
import spring.service.AdminService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO adminDTO){
        adminRepo.save(mapper.map(adminDTO, Admin.class));
    }

    @Override
    public AdminDTO getAdmin(String id){
        return mapper.map(adminRepo.findById(id),AdminDTO.class);
    }

    @Override
    public List<AdminDTO> getAllAdmins(){
        return mapper.map(adminRepo.findAll(), new TypeToken<List<AdminDTO>>() {}.getType());
    }
}

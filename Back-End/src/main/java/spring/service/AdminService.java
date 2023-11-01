package spring.service;

import spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);

    AdminDTO getAdmin(String id);

    List<AdminDTO> getAllAdmins();
}

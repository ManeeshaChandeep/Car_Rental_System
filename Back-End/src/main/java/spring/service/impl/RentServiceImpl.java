package spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dto.RentDTO;
import spring.dto.RentDetailsDTO;
import spring.entity.Rent;
import spring.entity.RentDetails;
import spring.repo.RentRepo;
import spring.service.RentService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveRent(RentDTO dto){

        Rent rent =mapper.map(dto,Rent.class);
        List<RentDetails> details =new ArrayList();

        for (RentDetailsDTO detail : dto.getRentDetails()) {
            RentDetails rentDetails = new RentDetails();
            rentDetails.setRentid(detail.getRentid());
            rentDetails.setCarid(detail.getCarid());
            rentDetails.setDriver(detail.getDriver());
            details.add(rentDetails);
        }
        rent.setRentDetails(details);

        repo.save(rent);
    }
}

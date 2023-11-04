package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Rent;

public interface RentRepo extends JpaRepository <Rent,String>{

}

package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.RentDetails;

public interface RentDetailsRepo extends JpaRepository<RentDetails,String> {
}

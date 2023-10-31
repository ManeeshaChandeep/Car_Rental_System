package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}

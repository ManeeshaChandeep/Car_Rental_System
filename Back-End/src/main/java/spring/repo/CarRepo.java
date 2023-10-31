package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Car;

public interface CarRepo extends JpaRepository<Car,String> {
}

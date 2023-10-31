package spring.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver,String> {
}

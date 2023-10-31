package spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@Entity
public class Car {
    @Id
    String registernumber;
    String brand;
    String rates;
    String frontview;
    String backview;
    String freemilage;
    String sideview;
    String interior;
    String numberofpassengers;
    String type;
    String dailyrate;
}

package spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
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
    String mothlyrate;
    String priceofextrakm;
    String vehicleavailabilitytype;
    String color;

}

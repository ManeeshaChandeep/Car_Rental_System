package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.entity.RentDetails;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class  RentDTO{

    private String rentid;
    private String customerid;
    private String pickupDate;
    private String returnDate;
    private List<RentDetailsDTO> rentDetails;
}

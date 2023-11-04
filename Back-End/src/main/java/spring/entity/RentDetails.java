package spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(RentDetails_PK.class)
public class RentDetails {
    @Id
    private String rentid;
    @Id
    private String carid;

    private String driver;

    @ManyToOne
    @JoinColumn(name = "rentID",referencedColumnName = "RentID",insertable = false,updatable = false)
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "carID",referencedColumnName = "registernumber",insertable = false,updatable = false)
    private Car car;
}

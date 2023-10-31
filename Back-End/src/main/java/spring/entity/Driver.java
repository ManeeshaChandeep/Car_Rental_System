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
public class Driver {
    @Id
    String nicnumber;
    String licensecardnumber;
    String yourname;
    String address;
    String availability;
    String phonenumber;
    String email;
    String username;
    String password;
}

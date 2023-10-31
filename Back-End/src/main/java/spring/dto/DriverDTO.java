package spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
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

package spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    String id;
    String name;
    String email;
    String phonenumber;
    String username;
    String password;
    String nicnumber;
    String address;
    String idcardfrontphoto;
    String idcardbackphoto;
}

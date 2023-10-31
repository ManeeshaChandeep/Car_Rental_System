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
public class Customer {
    @Id
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

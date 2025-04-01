package com.example.hotelManagement.user;

import jakarta.persistence.*;
import lombok.*;

 //for JPA /JDBC to interact with replication
 // for update other attributes in user to access @Data only create reqArgs/noArgs not all args
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Table(name = "user_detailss", schema = "public")// for update other attributes in hotel to access
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;


}

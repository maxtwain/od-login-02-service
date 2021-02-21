package com.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.serial.UserSerial;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
@JsonSerialize(using = UserSerial.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_type_fk")
    @JsonManagedReference
    private UserType userType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_address_jt",
            joinColumns = @JoinColumn(name = "user_fk", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_fk", referencedColumnName = "address_id"))
//    @JsonIgnoreProperties("users")
    private Set<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_fk")
    @JsonManagedReference
    private Credential credential;

    public User(String firstName, String lastName, String email, String phoneNumber,
                UserType userType, Set<Address> addresses, Credential credential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.addresses = addresses;
        this.credential = credential;
    }
}

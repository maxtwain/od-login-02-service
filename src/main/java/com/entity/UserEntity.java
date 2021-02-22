package com.entity;

import com.obj.Address;
import com.obj.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_type_fk")
    private UserTypeEntity userTypeEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address_jt",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "address_fk"))
    private Set<AddressEntity> addressEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_fk")
    private CredentialEntity credentialEntity;

    public UserEntity(User user){
        userId = user.getUserId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        userTypeEntity = new UserTypeEntity(user.getUserType());
        addressEntities = new HashSet<>();
        for (Address address: user.getAddresses()){
            addressEntities.add(new AddressEntity(address));
        }
        credentialEntity = new CredentialEntity(user.getCredential());
    }
}

package com.obj;

import com.entity.AddressEntity;
import com.entity.CredentialEntity;
import com.entity.UserEntity;
import com.entity.UserTypeEntity;
import lombok.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserType userType;
    private List<Address> addresses;
    private Credential credential;

    public User(UserEntity userEntity){
        userId = userEntity.getUserId();
        firstName = userEntity.getFirstName();
        lastName = userEntity.getLastName();
        email = userEntity.getEmail();
        phoneNumber = userEntity.getPhoneNumber();
        userType = new UserType(userEntity.getUserTypeEntity());
        addresses = new ArrayList<>();
        for (AddressEntity addressEntity: userEntity.getAddressEntities()){
            addresses.add(new Address(addressEntity));
        }
        credential = new Credential(userEntity.getCredentialEntity());
    }
    public User(String firstName, String lastName, String email, String phoneNumber,
                UserType userType, List<Address> addresses, Credential credential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.addresses = addresses;
        this.credential = credential;
    }
}

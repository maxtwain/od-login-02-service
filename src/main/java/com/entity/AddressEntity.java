package com.entity;

import com.obj.Address;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city_address")
    private String cityAddress;

    @Column(name = "zip_address")
    private String zipAddress;

    @Column(name = "state_address")
    private String stateAddress;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "addressEntities")
    private Set<UserEntity> userEntities;

    public AddressEntity(Address address){
        addressId = address.getAddressId();
        streetAddress = address.getStreetAddress();
        cityAddress = address.getCityAddress();
        zipAddress = address.getZipAddress();
        stateAddress = address.getStateAddress();
    }
}

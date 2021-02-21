package com.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.serial.AddressSerial;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "addressId")
//@JsonIgnoreProperties(value = {"users"})
@JsonSerialize(using = AddressSerial.class)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    @Setter(AccessLevel.NONE)
    private int addressId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city_address")
    private String cityAddress;

    @Column(name = "zip_address")
    private String zipAddress;

    @Column(name = "state_address")
    private String stateAddress;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_address_jt",
            joinColumns = @JoinColumn(name = "address_fk", referencedColumnName = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "user_fk", referencedColumnName = "user_id"))
    private Set<User> users;

    public Address(String streetAddress, String cityAddress, String zipAddress,
                   String stateAddress) {
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.zipAddress = zipAddress;
        this.stateAddress = stateAddress;
    }
}

package com.obj;

import com.entity.AddressEntity;
import lombok.*;

import javax.transaction.Transactional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Address {
    private Integer addressId;
    private String streetAddress;
    private String cityAddress;
    private String zipAddress;
    private String stateAddress;

    public Address(AddressEntity addressEntity){
        addressId = addressEntity.getAddressId();
        streetAddress = addressEntity.getStreetAddress();
        cityAddress = addressEntity.getCityAddress();
        zipAddress = addressEntity.getZipAddress();
        stateAddress = addressEntity.getStateAddress();
    }
    public Address(String streetAddress, String cityAddress, String zipAddress,
                         String stateAddress) {
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.zipAddress = zipAddress;
        this.stateAddress = stateAddress;
    }
}

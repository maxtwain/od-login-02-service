package com.access;

import com.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<AddressEntity, Integer> {
    Boolean existsByStreetAddressAndCityAddressAndZipAddressAndStateAddress(
            String street, String city, String zip, String state);
    AddressEntity getAddressEntityByStreetAddressAndCityAddressAndZipAddressAndStateAddress(
            String street, String city, String zip, String state);
}

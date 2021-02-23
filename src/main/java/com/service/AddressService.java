package com.service;

import com.access.AddressDao;
import com.entity.AddressEntity;
import com.obj.Address;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {
    public AddressDao addressDao;

    public void save(Address address){
        AddressEntity addressEntity = new AddressEntity(address);
        if(!addressDao.existsByStreetAddressAndCityAddressAndZipAddressAndStateAddress(
                addressEntity.getStreetAddress(), addressEntity.getCityAddress(),
                addressEntity.getZipAddress(), addressEntity.getStateAddress())){
            addressDao.save(addressEntity);
        }
    }

    Set<AddressEntity> syncAddresses(Set<AddressEntity> addresses){
        for (AddressEntity addressEntity: addresses){
            String street = addressEntity.getStreetAddress();
            String city = addressEntity.getCityAddress();
            String zip = addressEntity.getZipAddress();
            String state = addressEntity.getStateAddress();
            if (addressDao.existsByStreetAddressAndCityAddressAndZipAddressAndStateAddress(
                    street, city, zip, state)){
                addresses.remove(addressEntity);
                addresses.add(addressDao.getAddressEntityByStreetAddressAndCityAddressAndZipAddressAndStateAddress(
                        street, city, zip, state));
            }
        }
        return addresses;
    }
}

package com.service;

import com.access.AddressDao;
import com.entity.AddressEntity;
import com.obj.Address;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {
    public AddressDao addressDao;

    public void save(Address address){
        AddressEntity addressEntity = new AddressEntity(address);
        addressDao.save(addressEntity);
    }

}

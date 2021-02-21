package com.service;

import com.access.AddressDao;
import com.entity.Address;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {
    public AddressDao addressDao;

    public void save(Address address){
        addressDao.save(address);
    }

}

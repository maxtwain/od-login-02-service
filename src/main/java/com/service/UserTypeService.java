package com.service;

import com.access.UserTypeDao;
import com.entity.UserType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserTypeService {
    public UserTypeDao userTypeDao;

    public void save(UserType userType){
        userTypeDao.save(userType);
    }

}

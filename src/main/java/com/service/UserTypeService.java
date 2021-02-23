package com.service;

import com.access.UserTypeDao;
import com.entity.UserTypeEntity;
import com.obj.UserType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserTypeService {
    public UserTypeDao userTypeDao;

    public void save(UserType userType){
        UserTypeEntity userTypeEntity = new UserTypeEntity(userType);
        String userTypeStr = userTypeEntity.getUserType();
        if (!userTypeDao.existsByUserType(userTypeStr)){
            userTypeDao.save(userTypeEntity);
        }
    }

    UserTypeEntity syncUserType(UserTypeEntity userTypeEntity){
        if (userTypeDao.existsByUserType(userTypeEntity.getUserType())){
            return userTypeDao.findByUserType(userTypeEntity.getUserType());
        }
        return userTypeEntity;
    }

}

package com.service;

import com.access.UserDao;
import com.entity.AddressEntity;
import com.entity.UserEntity;
import com.obj.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    public UserDao userDao;

    public void save(User user){
        UserEntity userEntity = new UserEntity(user);
        userDao.save(userEntity);
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        List<UserEntity> userEntities = userDao.findAll();
        for (UserEntity userEntity: userEntities){
            users.add(new User(userEntity));
        }
        return users;
    }
    // unsafe
    public UserEntity getOne(){
        return userDao.findAll().get(0);
    }

    public String getOneAddress(){
        List<AddressEntity> addressEntities = new ArrayList<>(userDao.findAll().get(0).getAddressEntities());
        return addressEntities.get(0).getStreetAddress();
    }
}

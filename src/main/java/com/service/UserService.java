package com.service;

import com.access.UserDao;
import com.entity.AddressEntity;
import com.entity.CredentialEntity;
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
    public AddressService addressService;
    public CredentialService credentialService;
    public UserTypeService userTypeService;

    public void save(User user){
        UserEntity userEntity = new UserEntity(user);
        userEntity.setAddressEntities(
                addressService.syncAddresses(userEntity.getAddressEntities()));
        userEntity.setCredentialEntity(
                credentialService.syncCredential(userEntity.getCredentialEntity()));
        userEntity.setUserTypeEntity(
                userTypeService.syncUserType(userEntity.getUserTypeEntity()));
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
    public User findByUserId(int userId){
        UserEntity userEntity = userDao.findByUserId(userId);
        return new User(userEntity);
    }
    public String getOneAddress(){
        List<AddressEntity> addressEntities = new ArrayList<>(userDao.findAll().get(0).getAddressEntities());
        return addressEntities.get(0).getStreetAddress();
    }
    public void deleteByUserId(int userId){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        CredentialEntity credentialEntity = userDao.findByUserId(userId).getCredentialEntity();
        userEntity.setCredentialEntity(credentialEntity);
        userDao.save(userEntity);
        userDao.delete(userEntity);
    }
}

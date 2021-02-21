package com.service;

import com.access.UserDao;
import com.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    public UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }
    public List<User> findAll(){
        return userDao.findAll();
    }
    public User getOne(){
        return userDao.findAll().get(0);
    }
}

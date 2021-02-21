package com.access;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findAll();
}

package com.access;

import com.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
}

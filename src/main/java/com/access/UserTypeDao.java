package com.access;

import com.entity.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserTypeEntity, Integer> {
    Boolean existsByUserType(String userType);
    UserTypeEntity findByUserType(String userType);
}

package com.obj;

import com.entity.UserTypeEntity;
import lombok.*;

import javax.transaction.Transactional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class UserType {
    private Integer userTypeId;
    private String userType;

    public UserType(UserTypeEntity userTypeEntity){
        userTypeId = userTypeEntity.getUserTypeId();
        userType = userTypeEntity.getUserType();
    }
    public UserType(String userType) {
        this.userType = userType;
    }
}

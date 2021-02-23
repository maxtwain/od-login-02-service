package com.entity;

import com.obj.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_type")
public class UserTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private Integer userTypeId;

    @Column(name = "user_type")
    private String userType;

    @OneToMany(mappedBy = "userTypeEntity")
    private Set<UserEntity> userEntities;

    public UserTypeEntity(UserType userType){
        userTypeId = userType.getUserTypeId();
        this.userType = userType.getUserType();
    }
}

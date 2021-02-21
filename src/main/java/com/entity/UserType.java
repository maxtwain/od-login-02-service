package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    @Setter(AccessLevel.NONE)
    private int userTypeId;

    @Column(name = "user_type")
    private String userType;

    @OneToMany(mappedBy = "userType")
    @JsonBackReference
    private Set<User> users;

    public UserType(String userType) {
        this.userType = userType;
    }
}

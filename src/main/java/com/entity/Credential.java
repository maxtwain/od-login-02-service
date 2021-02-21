package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credential")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credential_id")
    @Setter(AccessLevel.NONE)
    private int credentialId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "credential")
    @JsonBackReference
    private User user;

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

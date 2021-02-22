package com.entity;

import com.obj.Credential;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credential")
public class CredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credential_id")
    @Setter(AccessLevel.NONE)
    private Integer credentialId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "credentialEntity")
    private UserEntity userEntity;

    public CredentialEntity(Credential credential){
        credentialId = credential.getCredentialId();
        username = credential.getUsername();
        password = credential.getPassword();
    }
}

package com.obj;

import com.entity.CredentialEntity;
import lombok.*;

import javax.transaction.Transactional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Credential {
    private Integer credentialId;
    private String username;
    private String password;

    public Credential(CredentialEntity credentialEntity){
        credentialId = credentialEntity.getCredentialId();
        username = credentialEntity.getUsername();
        password = credentialEntity.getPassword();
    }
    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

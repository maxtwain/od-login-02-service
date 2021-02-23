package com.service;

import com.access.CredentialDao;
import com.entity.CredentialEntity;
import com.obj.Credential;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CredentialService {
    public CredentialDao credentialDao;

    public void save(Credential credential){
        CredentialEntity credentialEntity = new CredentialEntity(credential);
        if (!credentialDao.existsByUsername(credential.getUsername())){
            credentialDao.save(credentialEntity);
        }
    }
    /** warning: This can create a many to one relationship if not used correctly.
     * @param credentialEntity with no id
     * @return credentialEntity with database id */
    CredentialEntity syncCredential(CredentialEntity credentialEntity){
        if (credentialDao.existsByUsername(credentialEntity.getUsername())){
            return credentialDao.getCredentialEntityByUsername(
                    credentialEntity.getUsername());
        }
        return credentialEntity;
    }
}

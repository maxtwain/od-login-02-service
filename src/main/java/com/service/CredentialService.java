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
        credentialDao.save(credentialEntity);
    }

}

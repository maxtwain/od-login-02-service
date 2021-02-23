package com.access;

import com.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialDao extends JpaRepository<CredentialEntity, Integer> {
    Boolean existsByUsername(String username);
    Boolean existsByUsernameAndPassword(String username, String password);
    CredentialEntity getCredentialEntityByUsername(String username);
    CredentialEntity getCredentialEntityByUsernameAndPassword(
            String username, String password);
}

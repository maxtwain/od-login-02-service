package com.access;

import com.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialDao extends JpaRepository<Credential, Integer> {

}

package com.access;

import com.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialDao extends JpaRepository<CredentialEntity, Integer> {

}

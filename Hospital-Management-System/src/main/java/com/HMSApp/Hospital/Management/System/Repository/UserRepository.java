package com.HMSApp.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.System.Entity.UserRegisterEntity;

@Repository
public interface UserRepository extends JpaRepository<UserRegisterEntity, Long> {

	public boolean existsByUsername(String email);

	public UserRegisterEntity findByUsername(String username);
}

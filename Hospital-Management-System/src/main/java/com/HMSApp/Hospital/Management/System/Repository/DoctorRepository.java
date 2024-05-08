package com.HMSApp.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.System.Entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {


	public DoctorEntity findByUsername(String username);

	public boolean existsByUsername(String username);

}

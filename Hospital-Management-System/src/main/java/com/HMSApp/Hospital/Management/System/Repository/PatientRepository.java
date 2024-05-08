package com.HMSApp.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.System.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

package com.HMSApp.Hospital.Management.System.Service;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.HMSApp.Hospital.Management.System.DTO.PatientDTO;
import com.HMSApp.Hospital.Management.System.Entity.Patient;

public interface PatientService {

	public Patient newUserRegistration(PatientDTO patientDTO);
	public List<PatientDTO> getAllThePatient();
	public ResponseEntity<Map<String,Boolean>> deletePatients(Long id) throws AttributeNotFoundException;
}

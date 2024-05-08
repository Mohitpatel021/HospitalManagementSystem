package com.HMSApp.Hospital.Management.System.ServiceImpl;

import com.HMSApp.Hospital.Management.System.DTO.PatientDTO;
import com.HMSApp.Hospital.Management.System.Entity.Patient;
import com.HMSApp.Hospital.Management.System.Repository.PatientRepository;
import com.HMSApp.Hospital.Management.System.Service.PatientService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  private PatientRepository patientRepository;

  @Override
  public Patient newUserRegistration(PatientDTO patientDTO) {
    Patient patient = PatientDTO.patientDTOToPatient_Mapper(patientDTO);
    patientRepository.save(patient);
    return patient;
  }

  @Override
  public List<PatientDTO> getAllThePatient() {
    List<Patient> patients = patientRepository.findAll();
    List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
    PatientDTO patientDTO;
    for (Patient patient : patients) {
      patientDTO = PatientDTO.patientToDTO_Mapper(patient);
      patientsDTO.add(patientDTO);
    }
    return patientsDTO;
  }

  @Override
  public ResponseEntity<Map<String, Boolean>> deletePatients(Long id)
    throws AttributeNotFoundException {
    Patient patient = patientRepository
      .findById(id)
      .orElseThrow(() ->
        new AttributeNotFoundException("Patient Not Found with the ID : " + id)
      );
    patientRepository.delete(patient);
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    response.put("Deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}

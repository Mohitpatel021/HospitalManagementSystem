package com.HMSApp.Hospital.Management.System.Controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.DTO.PatientDTO;
import com.HMSApp.Hospital.Management.System.Entity.Patient;
import com.HMSApp.Hospital.Management.System.Service.PatientService;
import com.HMSApp.Hospital.Management.System.ServiceImpl.PatientServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/v1")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/create-patient")
	public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO){
		if(patientDTO!=null) {
		Patient patient=patientService.newUserRegistration(patientDTO);
		PatientDTO patientDTO2=PatientDTO.patientToDTO_Mapper(patient);
		return new ResponseEntity<>(patientDTO2,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("An Error Occured when Registering a Patient!! ",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/all-patient")
	public ResponseEntity<List<?>>getAllThePatient(){
		List<PatientDTO> allPatients=patientService.getAllThePatient();
		return new ResponseEntity <List<?>>(allPatients,HttpStatus.OK);
	}
	@DeleteMapping("/delete-patient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatients(@PathVariable Long id) throws AttributeNotFoundException{
		return patientService.deletePatients(id);
	}
}

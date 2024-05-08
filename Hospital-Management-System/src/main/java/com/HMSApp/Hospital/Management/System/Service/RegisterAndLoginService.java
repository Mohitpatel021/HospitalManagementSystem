package com.HMSApp.Hospital.Management.System.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.HMSApp.Hospital.Management.System.DTO.JwtResponse;
import com.HMSApp.Hospital.Management.System.DTO.LoginRequest;
import com.HMSApp.Hospital.Management.System.Entity.CommonRequest;

public interface RegisterAndLoginService {

	public ResponseEntity<Map<String,String>> registerUser(CommonRequest commonRequest);

//	public ResponseEntity<?> registerDoctor(DoctorDTO doctorDTO);
	public JwtResponse login(LoginRequest loginRequest);
}

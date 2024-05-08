package com.HMSApp.Hospital.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.DTO.JwtResponse;
import com.HMSApp.Hospital.Management.System.DTO.LoginRequest;
import com.HMSApp.Hospital.Management.System.Entity.CommonRequest;
import com.HMSApp.Hospital.Management.System.Exception.InternalServerException;
import com.HMSApp.Hospital.Management.System.Service.RegisterAndLoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
@Tag(name = "Login and Registration Controller", description = "API Related to User Authentication")
public class RegisterAndLoginController {
	@Autowired
	private RegisterAndLoginService registerAndLoginService;

	@PostMapping("/save-user")
	@Operation(summary = "Authentication User", description = "Endpoint to register a User")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User Registration Successfully", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Invalid or malformed request. Registration failed.", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<?> registerUser(@Valid @RequestBody CommonRequest commonRequest) {
		if (commonRequest != null) {
			return registerAndLoginService.registerUser(commonRequest);
		}
		throw new InternalServerException("User Registration is Failed!!");
	}

//	@PostMapping("/save-doc")
//	@Operation(summary = "Authentication User", description = "Endpoint to register a Doctor")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Doctor Registration Successfully", content = @Content(mediaType = "application/json")),
//			@ApiResponse(responseCode = "400", description = "Invalid or malformed request. Registration failed.", content = @Content(mediaType = "application/json")) })
//	public ResponseEntity<?> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
//		if (doctorDTO != null) {
//			return registerAndLoginService.registerDoctor(doctorDTO);
//		} else {
//			throw new InternalServerException("Doctor Registration is Failed!!");
//		}
//	}

	@PostMapping("/login")
	@Operation(summary = "Authorization User", description = "Endpoint to Login a User/Doctor")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Doctor/User Login Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = JwtResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid or malformed request. Login failed.", content = @Content(mediaType = "application/json")) })
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		if (loginRequest != null) {
			JwtResponse jwtResponse = registerAndLoginService.login(loginRequest);
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		}
		throw new InternalServerException("Login Failed!!Please Try Again later");
	}
}

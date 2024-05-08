package com.HMSApp.Hospital.Management.System.DTO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.HMSApp.Hospital.Management.System.Entity.DoctorEntity;
import com.HMSApp.Hospital.Management.System.Entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class DoctorDTO {

	@NotNull(message = "Username Should not be Blank!!")
	private String username;
	
	private String doc_specilization;
	
	private String doc_hospital;
	
	@Email(message = "Please Enter a Valid Email!!")
	private String email;
	
	@NotNull(message = "Password should not be Blank!!")
	private String password;
	
	private String doc_Address;
	
	private String doc_Hospital_Address;

	private String doc_phoneNumber;
	
	private String gender;
	
	private String age;
	
	private Role role;
	
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDoc_specilization() {
		return doc_specilization;
	}

	public void setDoc_specilization(String doc_specilization) {
		this.doc_specilization = doc_specilization;
	}

	public String getDoc_hospital() {
		return doc_hospital;
	}

	public void setDoc_hospital(String doc_hospital) {
		this.doc_hospital = doc_hospital;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoc_Address() {
		return doc_Address;
	}

	public void setDoc_Address(String doc_Address) {
		this.doc_Address = doc_Address;
	}

	public String getDoc_Hospital_Address() {
		return doc_Hospital_Address;
	}

	public void setDoc_Hospital_Address(String doc_Hospital_Address) {
		this.doc_Hospital_Address = doc_Hospital_Address;
	}
	

	public String getDoc_phoneNumber() {
		return doc_phoneNumber;
	}

	public void setDoc_phoneNumber(String doc_phoneNumber) {
		this.doc_phoneNumber = doc_phoneNumber;
	}

	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static DoctorEntity dtoToEntity(DoctorDTO doctorDTO) {
		DoctorEntity doctorEntity=new DoctorEntity();
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		doctorEntity.setUsername(doctorDTO.getUsername());
		doctorEntity.setEmail(doctorDTO.getEmail());
		doctorEntity.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
		doctorEntity.setDoc_Address(doctorDTO.getDoc_Address());
		doctorEntity.setDoc_Hospital_Address(doctorDTO.getDoc_Hospital_Address());
		doctorEntity.setDoc_hospital(doctorDTO.getDoc_hospital());
		doctorEntity.setDoc_specilization(doctorDTO.getDoc_specilization());
		doctorEntity.setDoc_phoneNumber(doctorDTO.getDoc_phoneNumber());
		doctorEntity.setRole(doctorDTO.getRole());
		doctorEntity.setAge(doctorDTO.getAge());
		doctorEntity.setGender(doctorDTO.getAge());
		return doctorEntity;
	}
	public static DoctorDTO entityToDTO(DoctorEntity doctorEntity) {
		DoctorDTO doctorDTO=new DoctorDTO();
		
		doctorDTO.setUsername(doctorEntity.getUsername());
		doctorDTO.setEmail(doctorEntity.getEmail());
		doctorDTO.setPassword(doctorEntity.getPassword());
		doctorDTO.setDoc_Address(doctorEntity.getDoc_Address());
		doctorDTO.setDoc_Hospital_Address(doctorEntity.getDoc_Hospital_Address());
		doctorDTO.setDoc_hospital(doctorEntity.getDoc_hospital());
		doctorDTO.setDoc_specilization(doctorEntity.getDoc_specilization());
		doctorDTO.setRole(doctorEntity.getRole());
		doctorDTO.setDoc_phoneNumber(doctorEntity.getDoc_phoneNumber());
		doctorDTO.setAge(doctorEntity.getAge());
		doctorDTO.setGender(doctorEntity.getGender());
		return doctorDTO;
	}
}

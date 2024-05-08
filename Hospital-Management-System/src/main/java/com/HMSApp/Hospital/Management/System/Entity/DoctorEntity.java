package com.HMSApp.Hospital.Management.System.Entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor_info")
public class DoctorEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doc_id;
	@Column(name="doc_name")
	private String username;
	@Column(name="doc_specilization")
	private String doc_specilization;
	@Column(name="doc_hospital")
	private String doc_hospital;
	@Column(name="email")
	private String email;
	@Column(name="doc_password")
	private String password;
	@Column(name="doc_Address")
	private String doc_Address;
	@Column(name="doc_Hospital_Address")
	private String doc_Hospital_Address;
	
	@Column(name="doc_phoneNumber")
	private String doc_phoneNumber;
	
	@Column(name="doc_age")
	private String age;
	
	@Column(name="doc_gender")
	private String gender;
	
	private Role role;
	
	public Long getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(Long doc_id) {
		this.doc_id = doc_id;
	}

	public void setUsername(String doc_name) {
		this.username = doc_name;
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

	public void setPassword(String doc_password) {
		this.password = doc_password;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}

package com.HMSApp.Hospital.Management.System.DTO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.HMSApp.Hospital.Management.System.Entity.Role;
import com.HMSApp.Hospital.Management.System.Entity.UserRegisterEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

	@NotNull(message = "Username Should not be Blank")
	private String userName;
	@Email(message = "Please Enter a Valid Email")
	@NotBlank(message = "Email can't be Blank")
	private String email;
	@NotBlank(message = "Password Should not be Blank")
	private String password;
	private String address;
	private String age;
	@NotBlank(message = "Gender Should not be Blank")
	private String gender;
	@NotBlank(message = "Contact Number Should not be Blank")
	private String phoneNumber;
	@NotBlank(message = "Role Should not be blank")
	private Role role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static UserDTO entityToDTO_Mapper(UserRegisterEntity userRegisterEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(userRegisterEntity.getUsername());
		userDTO.setEmail(userRegisterEntity.getEmail());
		userDTO.setPassword(userRegisterEntity.getPassword());
		userDTO.setAddress(userRegisterEntity.getUser_Address());
		userDTO.setGender(userRegisterEntity.getUser_Gender());
		userDTO.setPhoneNumber(userRegisterEntity.getPhoneNumber());
		userDTO.setAge(userRegisterEntity.getUser_Age());
		userDTO.setRole(userRegisterEntity.getRole());
		return userDTO;

	}

	public static UserRegisterEntity dtoToEntity_Mapper(UserDTO userDTO) {

		UserRegisterEntity userRegisterEntity = new UserRegisterEntity();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userRegisterEntity.setUserName(userDTO.getUserName());
		userRegisterEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userRegisterEntity.setUser_Address(userDTO.getAddress());
		userRegisterEntity.setEmail(userDTO.getEmail());
		userRegisterEntity.setUser_Gender(userDTO.getGender());
		userRegisterEntity.setUser_Age(userDTO.getAge());
		userRegisterEntity.setPhoneNumber(userDTO.getPhoneNumber());
		userRegisterEntity.setRole(userDTO.getRole());
		return userRegisterEntity;

	}
}

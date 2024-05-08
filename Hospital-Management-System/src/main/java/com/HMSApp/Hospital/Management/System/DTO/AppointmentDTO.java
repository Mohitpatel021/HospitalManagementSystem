package com.HMSApp.Hospital.Management.System.DTO;

import java.util.Date;

import com.HMSApp.Hospital.Management.System.Entity.Appointment;

public class AppointmentDTO {

	private Long id;
	
	private String name;
	
	private String age;
	
	private String symptoms;
	
	private String number;
	
	private Date appointmentTime;
	
	private String disease;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public static AppointmentDTO appointment_To_DTO_Mapper(Appointment appointment) {
		
		AppointmentDTO appointmentDTO=new AppointmentDTO();
		appointmentDTO.setId(appointment.getId());
		appointmentDTO.setName(appointment.getName());
		appointmentDTO.setAge(appointment.getAge());
		appointmentDTO.setSymptoms(appointment.getSymptoms());
		appointmentDTO.setNumber(appointment.getNumber());
		appointmentDTO.setDisease(appointment.getDisease());
		appointmentDTO.setAppointmentTime(appointment.getAppointmentTime());
		return appointmentDTO;
	}
public static Appointment appointmentDTO_To_Appointment_Mapper(AppointmentDTO appointmentDTO) {
		
		Appointment appointment=new Appointment();
		appointment.setId(appointmentDTO.getId());
		appointment.setName(appointmentDTO.getName());
		appointment.setAge(appointmentDTO.getAge());
		appointment.setSymptoms(appointmentDTO.getSymptoms());
		appointment.setNumber(appointmentDTO.getNumber());
		appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
		appointment.setDisease(appointment.getDisease());
		return appointment;
	}
}

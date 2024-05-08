package com.HMSApp.Hospital.Management.System.Service;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.HMSApp.Hospital.Management.System.DTO.AppointmentDTO;
import com.HMSApp.Hospital.Management.System.Entity.Appointment;

public interface AppointmentService {
	public Appointment createAppointment(AppointmentDTO appointmentDTO);
	public List<AppointmentDTO> getAllTheAppointments();
	public ResponseEntity<Map<String,Boolean>> deleteAppointments(Long id) throws AttributeNotFoundException ;
	public List<AppointmentDTO>fetchAppointmentBasedOnDisease(String username);
	
}

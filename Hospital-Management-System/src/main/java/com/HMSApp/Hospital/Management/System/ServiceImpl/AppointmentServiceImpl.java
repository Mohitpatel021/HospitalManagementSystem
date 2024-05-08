package com.HMSApp.Hospital.Management.System.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.HMSApp.Hospital.Management.System.DTO.AppointmentDTO;
import com.HMSApp.Hospital.Management.System.Entity.Appointment;
import com.HMSApp.Hospital.Management.System.Entity.UserRegisterEntity;
import com.HMSApp.Hospital.Management.System.Exception.InternalServerException;
import com.HMSApp.Hospital.Management.System.Repository.AppointmentRepository;
import com.HMSApp.Hospital.Management.System.Repository.UserRepository;
import com.HMSApp.Hospital.Management.System.Service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Appointment createAppointment(AppointmentDTO appointmentDTO) {
			Appointment appointment=AppointmentDTO.appointmentDTO_To_Appointment_Mapper(appointmentDTO);
			appointmentRepository.save(appointment);
			return appointment;
	}
	
	@Override
	public List<AppointmentDTO> getAllTheAppointments(){
		List<AppointmentDTO> appointmentsDTO=new ArrayList<AppointmentDTO>();
		List<Appointment> appointments=appointmentRepository.findAll();
		AppointmentDTO appointmentDTO;
		for(Appointment appointment:appointments) {
			appointmentDTO=AppointmentDTO.appointment_To_DTO_Mapper(appointment);
			appointmentsDTO.add(appointmentDTO);
		}
		return appointmentsDTO;
	}
	@Override
	public ResponseEntity<Map<String,Boolean>> deleteAppointments(Long id) throws AttributeNotFoundException{
		Appointment appointment=appointmentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found with the ID : "+id));
		appointmentRepository.delete(appointment);
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	}
	@Override
	public List<AppointmentDTO>fetchAppointmentBasedOnDisease(String username){
		if(username!=null) {
			UserRegisterEntity userRegisterEntity=userRepository.findByUsername(username);
		}
		else {
			throw new InternalServerException("User Not Found With this Username");
		}
		List<AppointmentDTO>appointmentBasedOnDisease=new ArrayList<AppointmentDTO>();
		return appointmentBasedOnDisease;
	}
}

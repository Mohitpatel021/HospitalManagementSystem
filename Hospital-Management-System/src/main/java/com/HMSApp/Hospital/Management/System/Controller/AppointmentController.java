package com.HMSApp.Hospital.Management.System.Controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.DTO.AppointmentDTO;
import com.HMSApp.Hospital.Management.System.Entity.Appointment;
import com.HMSApp.Hospital.Management.System.Service.AppointmentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/v2")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/save-appointment")
	public ResponseEntity<?> saveAppointment(@RequestBody AppointmentDTO appointmentDTO){
		if(appointmentDTO!=null) {
		 Appointment appointment= appointmentService.createAppointment(appointmentDTO);
		 AppointmentDTO appointmentDTo=AppointmentDTO.appointment_To_DTO_Mapper(appointment);
		return new ResponseEntity<>(appointmentDTo,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("An Error Occured When Fixing Up Your Appointment!!",HttpStatus.BAD_REQUEST);
		}	
	}
	
	@GetMapping("/all-appointment")
	public ResponseEntity<List<?>>fetchAllTheAppointment(){
		List<AppointmentDTO>allAppointment=appointmentService.getAllTheAppointments();
		return new ResponseEntity<List<?>>(allAppointment,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-appointment/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAppointments(@PathVariable Long id) throws AttributeNotFoundException{
		return appointmentService.deleteAppointments(id);
	}
	@GetMapping("/appointment")
	public ResponseEntity<List<?>> fetchAppointmentBasedOnDisease(@RequestHeader String username){
		return null;
	}
}

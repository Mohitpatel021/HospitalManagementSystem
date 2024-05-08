package com.HMSApp.Hospital.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.DTO.MedicineDTO;
import com.HMSApp.Hospital.Management.System.Entity.Medicine;
import com.HMSApp.Hospital.Management.System.Service.MedicineService;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping("/save-medicine")
	public ResponseEntity<?> saveMedicines(@RequestBody MedicineDTO medicineDTO) {
		if (medicineDTO != null) {
			return medicineService.saveMedicine(medicineDTO);
		} else {
			return new ResponseEntity<>("An Error Occured While Saving the medicine!!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all-medicine")
	public ResponseEntity<List<?>> fetchAllTheMedicine(
			@RequestParam(value = "searchParameter", required = false) String searchParameter) {
		List<MedicineDTO> medicines = medicineService.getAllTheMedicine(searchParameter);
		return new ResponseEntity<List<?>>(medicines, HttpStatus.OK);
	}

	@DeleteMapping("/delete-medicine/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable Long id) {
		return medicineService.deleteMedicine(id);
	}
}

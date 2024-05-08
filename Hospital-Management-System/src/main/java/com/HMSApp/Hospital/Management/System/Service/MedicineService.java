package com.HMSApp.Hospital.Management.System.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.HMSApp.Hospital.Management.System.DTO.MedicineDTO;

public interface MedicineService {

	public ResponseEntity<Map<String, String>> saveMedicine(MedicineDTO medicineDTO);

	public List<MedicineDTO> getAllTheMedicine(String searchParameter);

	public ResponseEntity<Map<String, String>> deleteMedicine(Long id);
}

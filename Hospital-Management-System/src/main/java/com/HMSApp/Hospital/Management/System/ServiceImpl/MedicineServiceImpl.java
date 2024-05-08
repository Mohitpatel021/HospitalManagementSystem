package com.HMSApp.Hospital.Management.System.ServiceImpl;

import com.HMSApp.Hospital.Management.System.DTO.MedicineDTO;
import com.HMSApp.Hospital.Management.System.Entity.Medicine;
import com.HMSApp.Hospital.Management.System.Repository.MedicineRepository;
import com.HMSApp.Hospital.Management.System.Service.MedicineService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

  @Autowired
  private MedicineRepository medicineRepository;

  @Override
  public ResponseEntity<Map<String, String>> saveMedicine(
    MedicineDTO medicineDTO
  ) {
    Medicine medicine = MedicineDTO.medicineDTO_To_Medicine_Mapper(medicineDTO);
    medicineRepository.save(medicine);
    Map<String, String> response = new HashMap<String, String>();
    response.put("Message", "Medicine Saved Successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public List<MedicineDTO> getAllTheMedicine(String searchParameter) {
    if (searchParameter != null && !searchParameter.isEmpty()) {
      List<MedicineDTO> allMedicineDTO = new ArrayList<MedicineDTO>();
      List<Medicine> allMedicines = medicineRepository.findByDrug(
        searchParameter
      );
      MedicineDTO medicineDTO;
      for (Medicine medicine : allMedicines) {
        medicineDTO = MedicineDTO.medicine_To_DTO_Mapper(medicine);
        allMedicineDTO.add(medicineDTO);
      }
      return allMedicineDTO;
    } else {
      List<MedicineDTO> allMedicineDTO = new ArrayList<MedicineDTO>();
      List<Medicine> allMedicines = medicineRepository.findAll();
      MedicineDTO medicineDTO;
      for (Medicine medicine : allMedicines) {
        medicineDTO = MedicineDTO.medicine_To_DTO_Mapper(medicine);
        allMedicineDTO.add(medicineDTO);
      }
      return allMedicineDTO;
    }
  }

  public ResponseEntity<Map<String, String>> deleteMedicine(Long id) {
    medicineRepository.deleteById(id);
    Map<String, String> response = new HashMap<String, String>();
    response.put("Message", "Medicine Deleted Successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}

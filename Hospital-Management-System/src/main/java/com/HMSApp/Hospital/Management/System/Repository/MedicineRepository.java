package com.HMSApp.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.System.Entity.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	List<Medicine> findByDrug(String searchParameter);

}

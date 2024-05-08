package com.HMSApp.Hospital.Management.System.DTO;

import com.HMSApp.Hospital.Management.System.Entity.Medicine;

public class MedicineDTO {
	private Long id;

	private String drug;

	private String available_stock;

	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getAvailable_stock() {
		return available_stock;
	}

	public void setAvailable_stock(String available_stock) {
		this.available_stock = available_stock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static MedicineDTO medicine_To_DTO_Mapper(Medicine medicine) {
		MedicineDTO medicineDTO = new MedicineDTO();
		medicineDTO.setId(medicine.getId());
		medicineDTO.setAvailable_stock(medicine.getStock());
		medicineDTO.setDrug(medicine.getDrug());
		medicineDTO.setPrice(medicine.getPrice());
		return medicineDTO;

	}

	public static Medicine medicineDTO_To_Medicine_Mapper(MedicineDTO medicineDTO) {
		Medicine medicine = new Medicine();
		medicine.setId(medicineDTO.getId());
		medicine.setStock(medicineDTO.getAvailable_stock());
		medicine.setDrug(medicineDTO.getDrug());
		medicine.setPrice(medicineDTO.getPrice());
		return medicine;
	}

}

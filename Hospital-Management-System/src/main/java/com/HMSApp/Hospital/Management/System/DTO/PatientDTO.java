package com.HMSApp.Hospital.Management.System.DTO;

import com.HMSApp.Hospital.Management.System.Entity.Patient;

public class PatientDTO {

	private Long id;
	private String patient_name;
	
	private String patient_age;
	
	private String  patient_blood_group;
	
	private String prescription;
	
	private String dose;
	
	private String fees;
	
	private String urgency;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_age() {
		return patient_age;
	}

	public void setPatient_age(String patient_age) {
		this.patient_age = patient_age;
	}

	public String getPatient_blood_group() {
		return patient_blood_group;
	}

	public void setPatient_blood_group(String patient_blood_group) {
		this.patient_blood_group = patient_blood_group;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	
	public static PatientDTO patientToDTO_Mapper(Patient patient) {
		PatientDTO patientDTO=new PatientDTO();
		patientDTO.setId(patient.getId());
		patientDTO.setPatient_name(patient.getName());
		patientDTO.setPatient_age(patient.getAge());
		patientDTO.setPatient_blood_group(patient.getBlood());
		patientDTO.setFees(patient.getFees());
		patientDTO.setDose(patient.getDose());
		patientDTO.setPrescription(patient.getPrescription());
		patientDTO.setUrgency(patient.getUrgency());
		return patientDTO;
		
	}
	
	public static Patient patientDTOToPatient_Mapper(PatientDTO patientDTO) {
		
		Patient patient=new Patient();
		patient.setId(patientDTO.getId());
		patient.setName(patientDTO.getPatient_name());
		patient.setAge(patientDTO.getPatient_age());
		patient.setBlood(patientDTO.getPatient_blood_group());
		patient.setFees(patientDTO.getFees());
		patient.setDose(patientDTO.getDose());
		patient.setPrescription(patientDTO.getPrescription());
		patient.setUrgency(patientDTO.getUrgency());
		return patient;
		
	}
}

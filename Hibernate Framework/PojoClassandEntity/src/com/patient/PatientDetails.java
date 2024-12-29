package com.patient;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientDetails {

	// Fields
	@Id
	private int patientId;
	private String patientName;
	private String patientDiagnosis;
	private String patientCity;
	private int patientAge;
	private long patientMobileNo;

	// No- Argument Constructor
	public PatientDetails() {

	}

	// Argument Constructor
	public PatientDetails(int patientId, String patientName, String patientDiagnosis, String patientCity,
			int patientAge, long patientMobileNo) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientDiagnosis = patientDiagnosis;
		this.patientCity = patientCity;
		this.patientAge = patientAge;
		this.patientMobileNo = patientMobileNo;
	}

	// Getter and Setter
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientDiagnosis() {
		return patientDiagnosis;
	}

	public void setPatientDiagnosis(String patientDiagnosis) {
		this.patientDiagnosis = patientDiagnosis;
	}

	public String getPatientCity() {
		return patientCity;
	}

	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMobileNo() {
		return patientMobileNo;
	}

	public void setPatientMobileNo(long patientMobileNo) {
		this.patientMobileNo = patientMobileNo;
	}

	// toString
	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patientName=" + patientName + ", patientDiagnosis="
				+ patientDiagnosis + ", patientCity=" + patientCity + ", patientAge=" + patientAge
				+ ", patientMobileNo=" + patientMobileNo + "]";
	}

}

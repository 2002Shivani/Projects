package com.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Employee {

	// Fields
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeDepartment;
	private int employeeAge;
	private long employeeMobileNo;
	private String employeeCity;
	private String employeeJoiningDate;

//No-Argument Constructor
	public Employee() {

	}

	// Argument Constructor
	public Employee(int employeeId, String employeeName, String employeeDepartment, int employeeAge,
			long employeeMobileNo, String employeeCity, String employeeJoiningDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeAge = employeeAge;
		this.employeeMobileNo = employeeMobileNo;
		this.employeeCity = employeeCity;
		this.employeeJoiningDate = employeeJoiningDate;
	}

	// Getter and Setter
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public long getEmployeeMobileNo() {
		return employeeMobileNo;
	}

	public void setEmployeeMobileNo(long employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeJoiningDate() {
		return employeeJoiningDate;
	}

	public void setEmployeeJoiningDate(String employeeJoiningDate) {
		this.employeeJoiningDate = employeeJoiningDate;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDepartment="
				+ employeeDepartment + ", employeeAge=" + employeeAge + ", employeeMobileNo=" + employeeMobileNo
				+ ", employeeCity=" + employeeCity + ", employeeJoiningDate=" + employeeJoiningDate + "]";
	}

}

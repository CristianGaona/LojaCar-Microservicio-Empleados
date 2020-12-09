package lojacar.ms.employee.entity;

import java.io.Serializable;

import java.util.Date;


public class Activity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String description;
	private Integer employeeId;
	private Integer clientId;
	
	private Date  dateAssignment;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateAssignment() {
		return dateAssignment;
	}

	public void setDateAssignment(Date dateAssignment) {
		this.dateAssignment = dateAssignment;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
}

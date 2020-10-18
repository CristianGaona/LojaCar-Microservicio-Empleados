package lojacar.ms.employee.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table (name = "employee")
public class Employee implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	private String nombres;
	private String apellidos;
	private String rol;
	
	@JsonIgnoreProperties(value = {"employee"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmployeeActivity> employeeActivity;
	
	@Transient
	private List<Activity> activities;
	
	 public Employee() {
		 this.activities = new ArrayList<>();
		 this.employeeActivity = new ArrayList<>();
		
	 }

	public List<EmployeeActivity> getEmployeeActivity() {
		return employeeActivity;
	}

	public void setEmployeeActivity(List<EmployeeActivity> employeeActivity) {
		this.employeeActivity = employeeActivity;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	 
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}
	public void removeActivity(Activity activity) {
		this.activities.remove(activity);
	}
	//Agregar y eliminar alumnos conf remota
		public void addEmployeActivity(EmployeeActivity cursoAlumno) {
			this.employeeActivity.add(cursoAlumno);
		}
		
		public void removeEmployeActivity(EmployeeActivity cursoAlumno) {
			this.employeeActivity.remove(cursoAlumno);
		}
}

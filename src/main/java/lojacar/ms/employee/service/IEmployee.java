package lojacar.ms.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import lojacar.ms.employee.entity.Employee;
import lojacar.ms.employee.entity.EmployeeActivity;

public interface IEmployee {
	public List<Employee> findAll();
	public Page<Employee> findAll(Pageable pageable);
	public Employee findById(Integer id) ;
	public Optional<Employee> findById1(Integer id);
	public Employee save (Employee employee);
	public EmployeeActivity saveEA (EmployeeActivity employeActivity);
	
	/*public Iterable<Employee> obtenerAlumnosPorCursos(List<Integer> ids);*/
}

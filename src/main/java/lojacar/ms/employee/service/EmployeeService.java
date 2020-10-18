package lojacar.ms.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lojacar.ms.employee.clients.ActivityFeignClient;
import lojacar.ms.employee.entity.Activity;
import lojacar.ms.employee.entity.Employee;
import lojacar.ms.employee.entity.EmployeeActivity;
import lojacar.ms.employee.repository.EmployeeActivityRepository;
import lojacar.ms.employee.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployee {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	ActivityFeignClient activity;
	
	@Autowired
	EmployeeActivityRepository eaRepository;
	@Override
	public List<Employee> findAll() {
		
		return (List<Employee>) employeeRepo.findAll() ;
	}

	@Override
	public Employee findById(Integer id) {
		
		return employeeRepo.findById(id).orElse(null);
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Employee> findById1(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepo.findAll(pageable);
	}

	@Override
	public EmployeeActivity saveEA(EmployeeActivity employeActivity) {
	
		return eaRepository.save(employeActivity);
	}

	@Override
	public Iterable<Activity> obtenerAlumnosPorCursos(List<Integer> ids) {
		// TODO Auto-generated method stub
		return activity.obtenerAlumnosPorCursos(ids);
	}

	/*@Override
	public Iterable<Employee> obtenerAlumnosPorCursos(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	
}

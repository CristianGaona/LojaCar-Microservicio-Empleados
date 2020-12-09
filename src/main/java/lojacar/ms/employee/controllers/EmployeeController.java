package lojacar.ms.employee.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import lojacar.ms.employee.entity.Activity;
import lojacar.ms.employee.entity.Employee;
import lojacar.ms.employee.service.IEmployee;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployee service ;
	
	@GetMapping("listar1")
	public List<Employee> listar1(){
		
		return (List<Employee>)service.findAll();
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		List<Employee> cursos = ((List<Employee>) service.findAll()).stream().map(c -> {
			c.getEmployeeActivity().forEach(ca -> {
				Activity activity = new Activity();
				activity.setId(ca.getActivityId());
				c.addActivity(activity);
			});
			return c;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(cursos);
	}
	
	/*@GetMapping("/ver/{id}")
	public Employee detalle (@PathVariable Integer id ) {
		Employee account = service.findById(id);
		return account ;
		
	}*/
	
	@GetMapping("/paginaCurso")
	public ResponseEntity<?> listar(Pageable pageable) {
		Page<Employee> cursos = service.findAll(pageable).map(curso -> {
			curso.getEmployeeActivity().forEach(ca -> {
				Activity alumno = new Activity();
				alumno.setId(ca.getActivityId());
				curso.addActivity(alumno);
			});
			return curso;
		});
		return ResponseEntity.ok().body(cursos);
	}
	
	//Método que trae las actividades de otro microservicio
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Integer id) {
		Optional<Employee> opt = service.findById1(id);
		if (!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Employee employee = opt.get();
		if (employee.getEmployeeActivity().isEmpty() == false) {
			List<Integer> ids = employee.getEmployeeActivity().stream().map(ca -> {
				return ca.getActivityId();
			}).collect(Collectors.toList());
			List<Activity> activities = (List<Activity>) service.obtenerAlumnosPorCursos(ids);
			employee.setActivities(activities);
		}
		return ResponseEntity.ok().body(employee);
	}

}

package lojacar.ms.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;



import lojacar.ms.employee.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

	/*@Query("select c from Employee c join fetch c.employeeActivity a where a.activityId=?1")
	public Employee findCursoByAlumnoId(Integer id);*/
}

package lojacar.ms.employee.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import lojacar.ms.employee.entity.Activity;

@FeignClient(name = "micro-activity")
public interface ActivityFeignClient {

	@GetMapping("/alumnos-por-curso")
	public Iterable<Activity> obtenerAlumnosPorCursos(@RequestParam List<Integer> ids);
}

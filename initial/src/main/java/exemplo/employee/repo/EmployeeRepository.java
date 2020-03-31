package exemplo.employee.repo;


import exemplo.employee.dto.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeRepository {

    public Mono<Employee> findEmployeeById(String id) {
        Employee e = new Employee();
        e.setId(id);
        e.setNome(String.format("Nome %s", id));
        return Mono.just(e);
    }

    public Flux<Employee> findAllEmployees() {
        List<Employee> l = new ArrayList<Employee>();
        Employee e = new Employee();
        e.setId("i");
        e.setNome(String.format("Nome"));
        l.add(e);

        e = new Employee();
        e.setId("i1");
        e.setNome(String.format("Nome1"));
        l.add(e);

        return Flux.fromIterable(l);
    }
}

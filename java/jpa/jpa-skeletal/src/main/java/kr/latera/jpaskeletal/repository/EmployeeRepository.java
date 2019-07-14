package kr.latera.jpaskeletal.repository;

import kr.latera.jpaskeletal.entity.Employee;

import javax.persistence.EntityManager;
import java.util.Optional;

public class EmployeeRepository {

    private EntityManager em;

    private EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public static EmployeeRepository of(EntityManager em) {
        return new EmployeeRepository(em);
    }

    public Employee save(Employee emp) {
        em.persist(emp);
        return emp;
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }
}

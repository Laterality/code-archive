package kr.latera.jpaskeletal.repository;

import kr.latera.jpaskeletal.entity.Department;
import kr.latera.jpaskeletal.entity.Employee;

import javax.persistence.EntityManager;
import java.util.Optional;

public class DepartmentRepository {
    private EntityManager em;

    private DepartmentRepository(EntityManager em) {
        this.em = em;
    }

    public static DepartmentRepository of(EntityManager em) {
        return new DepartmentRepository(em);
    }

    public Department save(Department dept) {
        em.persist(dept);
        return dept;
    }

    public Optional<Department> findById(Long id) {
        return Optional.ofNullable(em.find(Department.class, id));
    }
}

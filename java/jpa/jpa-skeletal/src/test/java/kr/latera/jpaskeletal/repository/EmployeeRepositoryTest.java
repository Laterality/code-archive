package kr.latera.jpaskeletal.repository;

import kr.latera.jpaskeletal.entity.Employee;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepositoryTest {

    private static EntityManagerFactory emf;

    private EntityManager em;
    private EmployeeRepository employeeRepository;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("test-pu");
    }

    @AfterAll
    static void cleanup() {
        emf.close();
    }

    @BeforeEach
    void initEm() {
        em = emf.createEntityManager();
        employeeRepository = EmployeeRepository.of(em);
    }

    @AfterEach
    void close() {
        em.close();
    }

    @Test
    void create() {
        Employee emp = employeeRepository.save(Employee.of("John", null));
        assertThat(emp.getId()).isNotNull();
    }

    @Test
    void findById() {
        Employee emp = employeeRepository.save(Employee.of("James", null));
        assertThat(employeeRepository.findById(emp.getId()).isPresent()).isTrue();
    }
}

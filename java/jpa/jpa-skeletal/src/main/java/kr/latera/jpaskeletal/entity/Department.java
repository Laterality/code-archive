package kr.latera.jpaskeletal.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "dept_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "dept")
    private List<Employee> employees = new ArrayList<>();

    private LocalDateTime createdDate;

    public Department of(String name) {
        Department dept = new Department();
        dept.name = name;
        dept.createdDate = LocalDateTime.now();
        return dept;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        emp.setDept(this);
    }
}

package kr.latera.jpaskeletal.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinTable(name = "belong_to",
        joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "dept_id"))
    private Department dept;

    private LocalDateTime createdDate;

    public static Employee of(String name, Department dept) {
        Employee emp = new Employee();
        emp.name = name;
        emp.dept = dept;
        emp.createdDate = LocalDateTime.now();

        return emp;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDept() {
        return dept;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}

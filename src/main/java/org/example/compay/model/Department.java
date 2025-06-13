package org.example.compay.model;

import jakarta.persistence.*;
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String name;


    @OneToOne
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    private Employee head;


    public Department() {
    }

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }
}

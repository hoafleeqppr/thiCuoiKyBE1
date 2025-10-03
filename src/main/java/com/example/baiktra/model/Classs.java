package com.example.baiktra.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes") // tên bảng
public class Classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;

    private String name;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    public Classs() {}

    public Classs(int class_id, String name) {
        this.class_id = class_id;
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

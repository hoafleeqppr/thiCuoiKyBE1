package com.example.baiktra.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    private String name;
    private double theory;
    private double practice;
    private String description;
    private String evaluate;

    // mỗi student thuộc 1 class
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classs clazz;

    public Student() {}

    public Student(int student_id, String name, double theory, double practice, String description, String evaluate, Classs clazz) {
        this.student_id = student_id;
        this.name = name;
        this.theory = theory;
        this.practice = practice;
        this.description = description;
        this.evaluate = evaluate;
        this.clazz = clazz;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Classs getClazz() {
        return clazz;
    }

    public void setClazz(Classs clazz) {
        this.clazz = clazz;
    }
}

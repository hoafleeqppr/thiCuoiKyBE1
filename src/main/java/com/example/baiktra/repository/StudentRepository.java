package com.example.baiktra.repository;

import com.example.baiktra.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s ORDER BY s.student_id DESC")
    List<Student> findLatestStudents();

    List<Student> findByNameContainingIgnoreCase(String keyword);
}

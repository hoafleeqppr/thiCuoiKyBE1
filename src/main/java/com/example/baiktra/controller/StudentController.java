package com.example.baiktra.controller;

import com.example.baiktra.model.Student;
import com.example.baiktra.repository.StudentRepository;
import com.example.baiktra.repository.ClasssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClasssRepository classsRepository;

    @GetMapping("")
    public String listStudents(Model model, @ModelAttribute("successMessage") String successMessage) {
        model.addAttribute("students", studentRepository.findLatestStudents());
        return "student-list";
    }


    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        return "student-detail";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classes", classsRepository.findAll());
        return "student-add";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            model.addAttribute("classes", classsRepository.findAll());
            return "student-edit"; // file student-edit.html
        } else {
            return "redirect:/students";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(id);

        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = studentRepository.findByNameContainingIgnoreCase(keyword);
        model.addAttribute("students", students);
        return "student-list";
    }
}

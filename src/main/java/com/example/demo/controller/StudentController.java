package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";//redirect to students page after adding a student
	}
	
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student,
			Model model) {
		//get student from database by id, and modify its fields
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());;
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}

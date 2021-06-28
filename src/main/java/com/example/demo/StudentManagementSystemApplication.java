package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Student student1 = new Student("William", "Cai", "williamcai2028@gmail.com");
		studentRepository.save(student1);
		
		Student student2 = new Student("Michelle", "Ding", "michelle_ding@msn.com");
		studentRepository.save(student2);
		
		Student student3 = new Student("John", "Doe", "whatever");
		studentRepository.save(student3);
		*/
	}

}

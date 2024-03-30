package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")  //use to map request on server
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/insert")
	public String insertStudent(@RequestBody Student student)
	{
		return service.insertStudent(student);	
	}

	@PostMapping("/insertMultiple")
	public String insertMultipleStudent(@RequestBody List<Student> list)
	{
		return service.insertMultipleStudent(list);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudents()
	{
		List<Student> list=service.getAllStudents();
		return list;
	}
	
	
    @DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
    	return service.updateStudent(student);
	}
    
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id)
    {
    	return service.getStudent(id);
    }
    
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.StudentDao;
import com.example.entity.Student;

@org.springframework.stereotype.Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public String insertStudent(Student student)
	{
		return dao.insertStudent(student);
	}


	public String insertMultipleStudent(List<Student> list) {
		return dao.insertMultipleStudent(list);

	}


	public List<Student> getAllStudents() {
		List<Student> list=dao.getAllStudent();
		return list;
		}


	public String deleteStudent(int id) {
		return dao.deleteStudent(id);
	}


	public String updateStudent(Student student) {
		return dao.updateStudent(student);
	}


	public Student getStudent(int id) {
		return dao.getStudent(id);
	}
}

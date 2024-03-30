package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

//in repository all the methods are present that are require for database operation
@Repository
public class StudentDao {
	@Autowired  //inject sessionfactory object from spring container
	private SessionFactory sessionFactory;

	public String insertStudent(Student student) {
		Session session =sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Object savedStudent=session.save(student);
		transaction.commit();
		session.close();
		return "Student Inserted Successfully";
	}

	public String insertMultipleStudent(List<Student> list) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		for (Student students : list) {
			session.save(students);
		}
		transaction.commit();
		session.close();
		return"Multiple Student Inserted Successfully";
	}

	public List<Student> getAllStudent() {
		Session session=sessionFactory.openSession();
		CriteriaBuilder cr=session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery=cr.createQuery(Student.class);
        // Specify criteria root
        criteriaQuery.from(Student.class);

        // Execute query
        List<Student> students = session.createQuery(criteriaQuery).getResultList();

       session.close(); 
		return students;
	}

	public String deleteStudent(int id) {
		
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=session.load(Student.class, id);
		session.delete(student);
		transaction.commit();
		
		session.close();
		
		return "Student delete Successfully";
		
	}

	public String updateStudent(Student student) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
		return "Student Successfully Updated";
	}

	public Student getStudent(int id) {
		Session session= sessionFactory.openSession();
		Student student=session.load(Student.class, id);
		session.close();
		return student;
	}
	

}

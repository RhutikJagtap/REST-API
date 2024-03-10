package com.customermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;import org.springframework.web.bind.annotation.PathVariable;

import com.customermanagement.entity.Customer;


@Repository
public class CustomerDao  {

//	@Autowired
//	private SessionFactory sessionFactory;

	SessionFactory sessionFactory;

	public CustomerDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public String insertCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(customer);

		transaction.commit();

		session.close();

		return "Customer insert Succesfully";
	}

	public Customer getCustomerById(int id) {
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, id);

		session.close();

		return customer;
	}

	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		Query<Customer> query = session.createQuery("from Customer");
		List<Customer> list = query.list();

		session.close();
		return list;

	}

	
	public String updateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
		
		session.close();
		
		return "Customer updated Successfully";

	}
	
	
	public String deleteCustomer(int id)
	{
		Session session=sessionFactory.openSession();
		Customer customer=session.get(Customer.class, id);
		Transaction transaction=session.beginTransaction();
		session.delete(customer);
		transaction.commit();
		session.close();
		return "Customer deleted Successfully "+customer;
		
	}

	public String insertMultipleCustomers(List<Customer> customers) {
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		for (Customer customer : customers) {
			session.save(customer);
		}
		
		transaction.commit();
		session.close();
		
		return "Customers inserted Successfully \n"+customers;
	}
	
	//age equal too
	public List<Customer> getCustomersByAge(int age)
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age=:cust_age",Customer.class);
		customers.setParameter("cust_age", age);
		List<Customer> list=customers.list();
		
		session.close();
		return list;
	}
	
	//for searching get customer by using name
	public List<Customer> getCustomerByName(String firstName)//this firstName is variable in entity class not db
	{
		Session session=sessionFactory.openSession();
		//from entityclassname 
		 //hql query
		Query<Customer> customers=session.createQuery("from Customer c where c.firstName=:fName",Customer.class);
		customers.setParameter("fName",firstName );
		List<Customer> list=customers.list();
		
		session.close();
		return list;
	}
	
	
	public List<Customer> getCustomersByLessThanAge(int age)//this age is variable in entity class not db
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age<:cust_age",Customer.class);
		customers.setParameter("cust_age", age);
		List<Customer> list=customers.list();
		
		session.close();
		return list;
	}
	
	
	public List<Customer> getCustomersByGreaterThanAge(int age)//this age is variable in entity class not db
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age>:cust_age",Customer.class);
		customers.setParameter("cust_age", age);
		List<Customer> list=customers.list();
		
		session.close();
		return list;
	}
	
	
	public List<Customer> getCustomerByLastName(String lastName)
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.lastName=:last_Name");
		customers.setParameter("last_Name", lastName);
		
		List<Customer> list=customers.list();
		session.close();
		return list;
	}
	
	
	public Customer getCustomerByEmail(String email)
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.email=:Email");
		customers.setParameter("Email", email);
		//getSingleResult() method returns single result
		Customer customer=customers.getSingleResult();
		
		session.close();
		return customer;
	}

	public Customer getCustomerByMobileNumber(String mobileNumber)
	{
		Session session=sessionFactory.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.mobileNumber=:mobile");
		customers.setParameter("mobile", mobileNumber);
		//getSingleResult() method returns single result
		Customer customer=customers.getSingleResult();
		
		session.close();
		return customer;
	}


	public String updateFirstName(int id,String firstName)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setFirstName(firstName);
		session.update(customer);
		transaction.commit();
		session.close();
		return"Customer updated Successfully";
	}

	
	public String updateLastName(int id,String lastName)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setLastName(lastName);
		session.update(customer);
		transaction.commit();
		session.close();
		
		return"updated successfully";
		
	}
	
	public String updateEmailId(int id,String email)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Customer customer=session.get(Customer.class, id);
		customer.setEmail(email);
		session.update(customer);
		transaction.commit();
		session.close();
		
		return "Email upadated Successfully";
	}

	public String updateMobileNumber(int id,String mobileNumber)
	{
	
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer= session.get(Customer.class, id);
		customer.setMobileNumber(mobileNumber);
		session.update(customer);
		session.close();
		transaction.commit();
		return "Mobile Number has been updated";
	}
	
}

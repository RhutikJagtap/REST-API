package com.customermanagement.service;

import java.util.List;

import com.customermanagement.entity.Customer;

public interface CustomerService {

	String insertCustomer(Customer customer);

	Customer getCustomerById(int id);

	List<Customer> getCustomers();

	String updateCustomer(Customer customer);

	String deleteCustomer(int id);

	String insertMultipleCustomers(List<Customer> customers);

	List<Customer> getCustomerByName(String firstName);
	
	List<Customer> getCustomersByAge(int age);

	List<Customer> getCustomersByLessThanAge(int age);

	List<Customer> getCustomersByGreaterThanAge(int age);
	
	List<Customer> getCustomerByLastName(String lastName);
	
	Customer getCustomerByEmail(String email);
	
	Customer getCustomerByMobileNumber(String mobileNumber);
	
	String updateFirstName(int id,String firstName);

	String updateLastName(int id,String lastName);

	String updateEmailId(int id,String email);

	String updateMobileNumber(int id,String mobileNumber);

}

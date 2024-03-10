package com.customermanagement.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customermanagement.dao.CustomerDao;
import com.customermanagement.entity.Customer;
import com.customermanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public String insertCustomer(Customer customer) {

		return customerDao.insertCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {

		return customerDao.getCustomerById(id);
	}

	@Override
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	@Override
	public String updateCustomer(Customer customer) {
		String msg = customerDao.updateCustomer(customer);

		return msg;
	}

	@Override
	public String deleteCustomer(int id) {
		String msg = customerDao.deleteCustomer(id);
		return msg;
	}

	@Override
	public String insertMultipleCustomers(List<Customer> customers) {

		return customerDao.insertMultipleCustomers(customers);
	}

	@Override
	public List<Customer> getCustomerByName(String firstName) {

		List<Customer> list = customerDao.getCustomerByName(firstName);
		return list;
	}

	@Override
	public List<Customer> getCustomersByAge(int age) {

		return customerDao.getCustomersByAge(age);
	}

	@Override
	public List<Customer> getCustomersByLessThanAge(int age) {

		return customerDao.getCustomersByLessThanAge(age);
	}

	public List<Customer> getCustomersByGreaterThanAge(int age) {
		return customerDao.getCustomersByGreaterThanAge(age);
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {

		return customerDao.getCustomerByLastName(lastName);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public Customer getCustomerByMobileNumber(String mobileNumber) {
		return customerDao.getCustomerByMobileNumber(mobileNumber);
	}

	@Override
	public String updateFirstName(int id, String firstName) {
		return customerDao.updateFirstName(id, firstName);
	}

	@Override
	public String updateLastName(int id, String lastName) {
		return customerDao.updateLastName(id, lastName);
	}

	@Override
	public String updateEmailId(int id, String email) {
		return customerDao.updateEmailId(id, email);
	}

	@Override
	public String updateMobileNumber(int id, String mobileNumber) {
		return customerDao.updateMobileNumber(id, mobileNumber);
	}
}

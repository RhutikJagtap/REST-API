package com.customermanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.entity.Customer;
import com.customermanagement.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	//Insert Single Customer
	@PostMapping("/insertSingle")
	public String insertCustomer(@RequestBody Customer customer)
	{
		
		return customerService.insertCustomer(customer);
	}
	
	//Get  Customer By Id
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		Customer customer=customerService.getCustomerById(id);
		return customer;
	}

	
	//Get All Customers
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers()
	{
		
		return customerService.getCustomers();
	}
	
	//update customer 
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer)+customer;
		
	}
	
	//Delete Customer By id
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		return customerService.deleteCustomer(id);
	}
	
	//Insert Multiple Customer
	@PostMapping("/insertMultiple")
	public String insertMultipleCustomers(@RequestBody List<Customer> customers)
	{
		
		return customerService.insertMultipleCustomers(customers);
	}

	//Get Customer By First Name
	@GetMapping("/byName/{firstName}")
	public List<Customer> getCustomerByName(@PathVariable String firstName)
	{
		return customerService.getCustomerByName(firstName);
	}
	
	//Get Customer By Age
	@GetMapping("/byAge/{age}")
	public List<Customer> getCustomersByAge(@PathVariable int age)
	{
		return customerService.getCustomersByAge(age);
	}
	
	//Get Customer by less than age
	@GetMapping("/byLessThanAge/{age}")
	public List<Customer> getCustomersByLessThanAge(@PathVariable int age)
	{
		return customerService.getCustomersByLessThanAge(age);
	}
	
	//Get Customer by Greater than age
	@GetMapping("/byGreaterThanAge/{age}")
	public List<Customer> getCustomersByGreaterThanAge(@PathVariable int age)
	{
		return customerService.getCustomersByGreaterThanAge(age);
	}

	//Get Customer by Last Name
	@GetMapping("/byLastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable String lastName)
	{
		return customerService.getCustomerByLastName(lastName);
	}
	
	//Get Customer by email
	@GetMapping("/byEmail/{email}")
	public Customer getCustomerByEmail(@PathVariable String email)
	{
		return customerService.getCustomerByEmail(email);
	}
	
	//Get Customer by Mobile Number
	@GetMapping("/byMobileNumber/{mobileNumber}")
	public Customer getCustomerByMobileNumber(@PathVariable String mobileNumber)
	{
		return customerService.getCustomerByMobileNumber(mobileNumber);
	}
	
	//Update Customer First Name by Id
	@PutMapping("/updateFirstName/{id}")
	public String updateFirstName(@PathVariable int id,@RequestBody Map<String, String> request)
	{
		String firstName=request.get("firstName");
		return customerService.updateFirstName(id, firstName);
	}
	
	//Update Customer Last Name by Id
	@PutMapping("/updateLastName/{id}")
	public String updateLastName(@PathVariable int id,@RequestBody Map<String, String> request)
	{
		String lastName=request.get("lastName");
		return customerService.updateLastName(id, lastName);
	}

	//Update Customer EmailId  by Id
	@PutMapping("/updateEmailId/{id}")
	public String updateEmailId(@PathVariable int id,@RequestBody Map<String, String> request)
	{
		String emailId=request.get("EmailId");
		return customerService.updateEmailId(id, emailId);
	}

	//Update Customer Mobile Number  by Id
	@PutMapping("/updateMobileNumber/{id}")
	public String updateMobileNumber(@PathVariable int id,@RequestBody Map<String,String>request)
	{
		String mobileNumber=request.get("MobileNumber");//key 
		return customerService.updateMobileNumber(id, mobileNumber);
	}
	
}

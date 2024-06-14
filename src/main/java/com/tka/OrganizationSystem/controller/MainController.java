package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {

		String msg = service.addCountry(c);

		return msg;
	}

	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {

		String msg = service.updateCountry(id, c);

		return msg;

	}

	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {

		String msg = service.deleteCountry(id);

		return msg;
	}

	@GetMapping("getallrecord")
	public List<Country> getAllRecord() {

		List<Country> list = service.getAllRecord();
		return list;
	}

	@GetMapping("getparticularrecord/{id}")
	public Country getParticularRecord(@PathVariable int id) {

		Country country = service.getParticularRecord(id);

		System.out.println("Updated");

		return country;
	}

	@PostMapping("addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return msg;
	}

	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {

		String msg = service.updateEmployee(emp);

		return msg;

	}

	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id) {

		String msg = service.deleteEmployee(id);

		return msg;
	}

	@GetMapping("getallemployee")
	public List<Employee> getAllRecordofEmployee() {

		List<Employee> list = service.getAllRecordofEmployee();

		return list;
	}

	@GetMapping("getparticularemp/{id}")
	public Employee getParticularEmployee(@PathVariable int id) {

		Employee emp = service.getParticularEmployee(id);

		return emp;
	}

	@GetMapping("getempbystatus/{status}")
	public List<Employee> getAllRecordbyStatus(@PathVariable String status) {

		List<Employee> list = service.getAllRecordbyStatus(status);

		return list;
	}

	@PostMapping("login")
	public HashMap logIn(@RequestBody Employee emp) {

		HashMap map = service.logIn(emp);
		return map;
	}

	@GetMapping("getbyparticularsalary/{salary}")
	public List<Employee> getEmpBySalaryCon(@PathVariable double salary) {

		List<Employee> list = service.getEmpBySalaryCon(salary);
		return list;
	}

	@GetMapping("getsalarybyrange/{salary1}/{salary2}")
	public List<Employee> getSalaryRange(@PathVariable double salary1, @PathVariable double salary2) {

		List<Employee> list = service.getSalaryRange(salary1, salary2);
		return list;
	}

	@GetMapping("getempbycountry/{country}")
	public List<Employee> getEmployeebyCountry(@PathVariable String country) {
		List<Employee> list = service.getEmployeebyCountry(country);
		return list;
	}
}

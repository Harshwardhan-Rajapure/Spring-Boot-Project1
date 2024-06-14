package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDAO;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDAO dao;

	public String addCountry(Country c) {

		String msg = dao.addCountry(c);

		if (Objects.isNull(msg)) {
			msg = "Country is not addedd!!";
		}
		return msg;

	}

	public String updateCountry(int id, Country c) {

		String msg = dao.updateCountry(id, c);

		if (Objects.isNull(msg)) {
			msg = "Country is not updated!!";
		}
		return msg;
	}

	public String deleteCountry(int id) {

		String msg = dao.deleteCountry(id);

		if (Objects.isNull(msg)) {
			msg = "Country is not deleted";
		}
		return msg;

	}

	public List<Country> getAllRecord() {

		List<Country> list = dao.getAllRecord();

		if (Objects.isNull(list)) {
			// return Collections.EMPTY_LIST;
			list = new ArrayList<>();
		}

		return list;
	}

	public Country getParticularRecord(int id) {

		Country country = dao.getParticularRecord(id);

		if (Objects.isNull(country)) {
			country = null;
		}

		return country;

	}

	public String addEmployee(Employee emp) {

		String msg = dao.addEmployee(emp);

		if (Objects.isNull(msg)) {
			msg = "Employee is not addedd..";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {

		String msg = dao.updateEmployee(emp);

		if (Objects.isNull(msg)) {
			msg = "Employee is not updated!!";
		}
		return msg;
	}

	public String deleteEmployee(int id) {

		String msg = dao.deleteEmployee(id);

		if (Objects.isNull(msg)) {
			msg = "Employee is not Deleted!!";
		}
		return msg;
	}

	public List<Employee> getAllRecordofEmployee() {

		List<Employee> list = dao.getAllRecordofEmployee();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Employee getParticularEmployee(int id) {

		Employee emp = dao.getParticularEmployee(id);

		if (Objects.isNull(emp)) {
			emp = null;
		}
		return emp;
	}

	public List<Employee> getAllRecordbyStatus(String status) {

		List<Employee> list = dao.getAllRecordbyStatus(status);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public HashMap logIn(Employee emp) {

		Employee em = dao.logIn(emp);

		HashMap map = new HashMap();

		if (Objects.isNull(map)) {
			map.put("msg", "Invalid User!!");
			map.put("User", em);
		} else {
			map.put("msg", "Valid User!!");
			map.put("User", em);
		}
		return map;
	}

	public List<Employee> getEmpBySalaryCon(double salary) {

		List<Employee> list = dao.getEmpBySalaryCon(salary);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;

	}

	public List<Employee> getSalaryRange(double salary1, double salary2) {

		List<Employee> list = dao.getSalaryRange(salary1, salary2);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public List<Employee> getEmployeebyCountry(String country) {

		List<Employee> list = dao.getEmployeebyCountry(country);

		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}
}

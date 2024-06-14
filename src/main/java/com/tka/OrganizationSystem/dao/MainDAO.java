package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDAO {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(c);
			tx.commit();
			msg = "Country is addedd!!";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}

		}
		return msg;

	}

	public String updateCountry(int id, Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			country.setCname(c.getCname());

			session.merge(country);
			tx.commit();

			msg = "Country is updated!!";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String deleteCountry(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			session.remove(country);

			tx.commit();

			msg = "Country is Deleted!!";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public List<Country> getAllRecord() {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		List<Country> list = null;

		try {

			hqlQuery = "from Country";
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Country> query = session.createQuery(hqlQuery, Country.class);

			list = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public Country getParticularRecord(int id) {

		Session session = null;
		Transaction tx = null;
		Country country = null;
		

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			country = session.get(Country.class, id);

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	public String addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(emp);
			tx.commit();

			msg = "Employee is addedd..";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String updateEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setDepartment(emp.getDepartment());
			employee.setEmailid(emp.getEmailid());
			employee.setPhoneno(emp.getPhoneno());
			employee.setSalary(emp.getSalary());
			employee.setStatus(emp.getStatus());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());

			session.merge(employee);
			tx.commit();

			msg = "Employee is updated!!";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String deleteEmployee(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, id);
			session.remove(employee);

			tx.commit();

			msg = "Employee is Deleted!!";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllRecordofEmployee() {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee";
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			list = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public Employee getParticularEmployee(int id) {

		Session session = null;
		Transaction tx = null;
//		String msg = null;
		Employee employee = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			employee = session.get(Employee.class, id);

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

	public List<Employee> getAllRecordbyStatus(String status) {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee where status = :status";
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("status", status);
			list = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Employee logIn(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphoneno";
		Employee employee = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphoneno", emp.getPhoneno());

			employee = query.uniqueResult();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;

	}

	public List<Employee> getEmpBySalaryCon(double salary) {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee where salary > :mysalary";
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mysalary", salary);
			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public List<Employee> getSalaryRange(double salary1, double salary2) {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee where salary between :mysalary1 and :mysalary2";
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("mysalary1", salary1);
			query.setParameter("mysalary2", salary2);

			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Employee> getEmployeebyCountry(String country) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where country.cname = :mycountry";

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("mycountry", country);

			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}

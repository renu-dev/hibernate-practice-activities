package com.luv2code.hibernate.crud.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Employee.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			int employeeId = 1;
			session.beginTransaction();
			
			System.out.println("Query to get employee with company name wipro");
			List<Employee> empList = session.createQuery("from Employee e where e.company='Wipro'").getResultList();
			
			for(Employee emp:empList) {
				System.out.println("Emplyee details are: "+emp);
			}
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}

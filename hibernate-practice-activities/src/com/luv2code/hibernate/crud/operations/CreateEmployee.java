package com.luv2code.hibernate.crud.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Employee.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//Employee emp = new Employee("Yamini","Juneja","Altran");
			Employee emp1 = new Employee("Vinit","Srivastave","Wipro");
			Employee emp2 = new Employee("Rahul","Vishwakarma","Wipro");
			Employee emp3 = new Employee("Sudharashan","Upadhyay","Ace");
			
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}

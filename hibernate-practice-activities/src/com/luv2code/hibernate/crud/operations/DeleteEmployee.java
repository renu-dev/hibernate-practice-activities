package com.luv2code.hibernate.crud.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Employee.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int employeeId = 1;
			session.beginTransaction();
			
			System.out.println("Deleting Employee object of primary key 1");
			Employee emp1 = session.get(Employee.class, employeeId);
			
			session.delete(emp1); 
			//OR
			//session.createQuery("delete from Employee where employeeId=2");
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}

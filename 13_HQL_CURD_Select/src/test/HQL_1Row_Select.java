package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_1Row_Select {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
	
		String hql = "from Employee where id = 2";
		Query query = session.createQuery(hql);
		Employee emp = (Employee) query.uniqueResult();
		
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getSalary());
		
		session.close();
		sf.close();
	}

}

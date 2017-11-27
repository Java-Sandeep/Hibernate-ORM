package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_1Coloumn_Select {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf =  cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		// main code started
		String hql = "select name from Employee";
		Query query = session.createQuery(hql);
		List<String> lst = query.list();
			
		for(String name : lst)
		{
			System.out.println(name);
		}
		session.close();
		sf.close();
	}

}

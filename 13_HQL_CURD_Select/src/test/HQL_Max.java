package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_Max {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf =  cfg.buildSessionFactory();
	Session session = sf.openSession();
	
	String hql = "select max(salary) from Employee";
	Query q =session.createQuery(hql);

	float avg =(float) q.uniqueResult();
	System.out.println("Max of salary = "+avg);
	
	System.out.println("Min of salary = "+session.createQuery("select min(salary) from Employee").uniqueResult());
	System.out.println("Sum of salary = "+session.createQuery("select sum(salary) from Employee").uniqueResult());
	System.out.println("Count of salary = "+session.createQuery("select count(salary) from Employee").uniqueResult());
	
	session.close();
	sf.close();
}
}

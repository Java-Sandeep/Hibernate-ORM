package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_Agregate {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf =  cfg.buildSessionFactory();
	Session session = sf.openSession();
	
	String hql = "select avg(salary) from Employee";
	Query q =session.createQuery(hql);

	double avg =(Double) q.uniqueResult();
	System.out.println("avg salary = "+avg);
	session.close();
	sf.close();
}
}

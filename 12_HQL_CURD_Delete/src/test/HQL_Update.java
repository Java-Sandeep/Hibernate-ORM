package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class HQL_Update {
 public static void main(String[] args) {
	
	 Configuration cfg = new Configuration();
	 cfg.configure("resources/hibernate.cfg.xml");
	 SessionFactory sf =  cfg.buildSessionFactory();
	 
	 Session session = sf.openSession();
	 Transaction transaction = session.beginTransaction();
	 
	 // delete from table
	 String hql = "delete from Student where id = 333";
	 Query query = session.createQuery(hql);
	 int i = query.executeUpdate();
	 System.out.println("updated rows count = " + i);
	 
	 System.out.println("updated rows count = " + session.createQuery("delete from Student where id = 1007").executeUpdate());
	 
	 
	 transaction.commit();
	 session.close();
	 sf.close();
	 System.out.println("Operation performed successfully.........!!!!!");
}
}

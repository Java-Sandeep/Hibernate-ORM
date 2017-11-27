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
	 
	 // two column update
	 String hql1 = "update Student set name = 'Bill Gates', email = 'billgates@microsoft.com' where id  = 111";
	 
	 // primary key update
	 String hql2 = "update Student set id = 1007 where id  = 222";
	 
	 // single column update
	 String hql3 = "update Student set email = 'timcook@apple.com' where id  = 333";
	 
	 Query query1 = session.createQuery(hql1);
	 int i1 = query1.executeUpdate();
	 System.out.println("updated rows count = " + i1);
	 
	 Query query2 = session.createQuery(hql2);
	 int i2 = query2.executeUpdate();
	 System.out.println("updated rows count = " + i2);
	 
	 Query query3 = session.createQuery(hql3);
	 int i3 = query3.executeUpdate();
	 System.out.println("updated rows count = " + i3);
	 
	 
	 transaction.commit();
	 session.close();
	 sf.close();
	 System.out.println("Operation performed successfully.........!!!!!");
}
}

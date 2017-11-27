package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {
 public static void main(String[] args) {
	
	 Configuration cfg = new Configuration();
	 cfg.configure("resources/hibernate.cfg.xml");
	 SessionFactory sf =  cfg.buildSessionFactory();
	 
	 Session session = sf.openSession();
	 Transaction transaction = session.beginTransaction();
	 
	 Student st1 = new Student(111,"sandeep", "sandeep@gmail.com");
	 Student st2 = new Student(222,"sachin", "sachin@yahoo.com");
	 Student st3 = new Student(333,"rohit", "rohit@facebook.com");
	 
	 session.save(st1);
	 session.save(st2);
	 session.save(st3);
	 
	 transaction.commit();
	 
	 session.close();
	 sf.close();
	 System.out.println("Data saved successfully..........!!!");
	 
}
}

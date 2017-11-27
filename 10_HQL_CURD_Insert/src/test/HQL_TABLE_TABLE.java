package test;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class HQL_TABLE_TABLE {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
				
		Query q = session.createQuery("insert into NewStudent(id,name,email,address) "
				+ "select s.id, s.name, s.email, s.address from OldStudent s");
		int i =	q.executeUpdate();
		System.out.println("no of rows dumped from old table to new table = " + i);
		transaction.commit();
		
		session.close();
		sf.close();
		System.out.println("operation done");
	}
}

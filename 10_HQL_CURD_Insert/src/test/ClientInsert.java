package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class ClientInsert {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		OldStudent os1 = new OldStudent(1,"abc","abc@gmail.com","indore");
		OldStudent os2 = new OldStudent(2,"lmn","lmn@gmail.com","pune");
		OldStudent os3 = new OldStudent(3,"xyz","xyz@gmail.com","hyd");
		
		
		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		transaction.commit();
		
		session.close();
		sf.close();
		System.out.println("Data inserted successfully.......!");
	}

}

package Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Car;

public class Test {
	public static void main(String[] args) {
		
		// bean object created
		Car e = new Car();
		e.setId(1);
		e.setName("Mercadize");
		e.setPrice(5000000);
		e.setModelYear("Jan-2011");
		
		// creating Configuration class object
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		// creating SessionFactory(I) object creation
		SessionFactory sf = cfg.buildSessionFactory();
		
		// creating Session(I) object creation
		Session s = sf.openSession();
		
		// save data to hibarnate container
		s.save(e);

		// creating Transaction(I) object creation
		Transaction t = s.beginTransaction();
		
		// sending data to database
		t.commit();
		
		// removing data from session
		s.evict(e);
		
		System.out.println("All operation done");
	}
}

package Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Car;

public class Test {
	public static void main(String[] args) {
		
		// object state is transient
		System.out.println("transient object state");
		System.out.println("Bean class object creating");
		Car e = new Car();
		e.setId(2);
		e.setName("Mercadize");
		e.setPrice(5000000);
		e.setModelYear("Jan-2011");
		
		// creating configuration class object
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		System.out.println("configuration class object created");
		
		// creating session factory object creation
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("SessionFactory class object created");
		
		// session object creation
		Session s = sf.openSession();
		System.out.println("Session class object created");
		
		// object state is persistent
		s.save(e);
		System.out.println("now object is in \"persistent\" object state");
		

		// object state is permanent
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("permanent object state");
		
		// object state is deteched
		s.evict(e);
		System.out.println("deteched object state");
		
		System.out.println("All operation done");
	}
}

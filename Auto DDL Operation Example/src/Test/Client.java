package Test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client
{
	public static void main(String[] args)
	{
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		sf.close();
		
		System.out.println("table created successfully");
	}
}

package com.connect2java;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class App 
{
    public static void main( String[] args )
    {
         Session session = getSession();
         session.beginTransaction();
         
         Publisher publisher = new Publisher();
         publisher.setPublisherName("Sree & Co.");
         session.save(publisher);
         
         Book book1 = new Book();
         book1.setTitle("Book1");         
         book1.setPublisher(publisher);
         publisher.getBooks().add(book1);
         
         
         Book book2 = new Book();
         book2.setTitle("Book2");         
         book2.setPublisher(publisher);
         publisher.getBooks().add(book2);
         
         session.save(book1);
         session.save(book2);
         
         session.getTransaction().commit();
         System.out.println("One-to-Many is successful");
         
    }
    public static Session getSession() {
        
        Session session=null;
        try{
            Configuration configuration=  new Configuration();
            configuration.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            return session;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return session;        
        
     }
}
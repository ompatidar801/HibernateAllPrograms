package hibernateAdd;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class PersonInfoAdd 
{  
	public static void main(String[] args) {  
      
  
    Configuration cfg=new Configuration();  
    cfg.configure("personhibernate.cfg.xml");
      

    SessionFactory factory=cfg.buildSessionFactory();  

    Session session=factory.openSession();  
      
  
    Transaction t=session.beginTransaction();  
          
    PersonDTO e1=new PersonDTO();  
  
    e1.setFirstname("Fatesingh");  
    e1.setLastname("patidar");  
      
    session.save(e1);  
      
    t.commit();
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
} 

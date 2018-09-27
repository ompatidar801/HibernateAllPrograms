package generators;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AssignedGenerator {

	public static void main(String[] args) 
	{
		 Configuration cfg=new Configuration();  
		    cfg.configure("Generators.cfg.xml");
		      

		    SessionFactory factory=cfg.buildSessionFactory();  

		    Session session=factory.openSession();  
		      
		  
		    Transaction t=session.beginTransaction();  
		          
		    GeneratorsDTO e1=new GeneratorsDTO(); 
		   //e1.setId(445);
		    e1.setName("RAMESH");
		    e1.setAge(54);
		      
		    session.save(e1);  
		      
		    t.commit();
		    session.close();  

	}

}

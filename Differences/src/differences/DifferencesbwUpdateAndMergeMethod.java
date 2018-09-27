package differences;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DifferencesbwUpdateAndMergeMethod 
{
		static SessionFactory sf =  new Configuration().configure("DifferencesDTO.cfg.xml").buildSessionFactory();
		
		public static void main(String[] args) 
		{

		    Session session1 = sf.openSession();  
		       
		    DifferencesDTO e1 = (DifferencesDTO) session1.get(DifferencesDTO.class, Integer.valueOf(54));//passing id of employee  
		   // session1.close();  
		    e1.setName("guru");
		    e1.setAge(76);  
		       
		    Session session2 = sf.openSession();  
		    DifferencesDTO e2 = (DifferencesDTO) session1.get(DifferencesDTO.class, Integer.valueOf(54));//passing same id  
		      
		    Transaction tx=session2.beginTransaction();  
		    session2.merge(e1);  
		   // System.out.println("ID:"+e1.getId()+"Name:"+e1.getName()+"Age:"+e1.getAge()); 
		    tx.commit();  
		    session2.close();  
		    
		    Session session3 = sf.openSession();
		    DifferencesDTO current = (DifferencesDTO)session3.get(DifferencesDTO.class, 86);
	        System.out.println("Before merge: " + current.getName());
	        DifferencesDTO changed = new DifferencesDTO();
	        changed.setId(86);
	        changed.setName("Changed new Name");
	         //session3.update(changed); // Throws NonUniqueObjectException
	        session3.merge(changed); 
	        System.out.println("After merge: " + current.getName());


		}

}

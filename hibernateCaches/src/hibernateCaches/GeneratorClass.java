package hibernateCaches;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GeneratorClass {

	public static void main(String[] args) 
	{
		
		SessionFactory sessionFactory = new Configuration().configure("DifferencesDTO.cfg.xml").buildSessionFactory(); //Load Factory
		Session s = sessionFactory.openSession();
		
		

	}

}

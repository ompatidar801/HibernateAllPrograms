package differences;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DiffbwLoadandGetMethod 
{
	static SessionFactory sf =  new Configuration().configure("DifferencesDTO.cfg.xml").buildSessionFactory();
	static Session sn1 = sf.openSession();
	public static void loadMethod()
	{
		DifferencesDTO acd1 = (DifferencesDTO) sn1.load(DifferencesDTO.class, 54);
	//	System.out.println("ID:"+acd1.getId()+"Name:"+acd1.getName()+"Age:"+acd1.getAge());
		
		sn1.close();

	}
	
	public static void getMethod()
	{
		
		Session sn2 = sf.openSession();
		DifferencesDTO acd2 = (DifferencesDTO) sn2.get(DifferencesDTO.class, 54);
	//	System.out.println("ID:"+acd2.getId()+"Name:"+acd2.getName()+"Age:"+acd2.getAge());		
		sn2.close();
	}
	
	public static void main(String[] args) 
	{
		loadMethod();
		//getMethod();

	}

}

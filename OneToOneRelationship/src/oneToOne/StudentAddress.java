package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentAddress 
{
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sn = sf.openSession();
		
		Student s = new Student();
		s.setStID(354);
		s.setStName("Mohan");
		
		Address ad = new Address();
		ad.setAddressID(4545);
		ad.setCity("Delhi");
		ad.setState("Uttar Pradesh");
		
		ad.setStudent(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(ad);
		tr.commit();
		sn.close();
		
	}
}

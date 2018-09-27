package hb1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentInfocfg
{

	public static void main(String[] args) 
	{
		StudentDTO sdto = new StudentDTO();
		sdto.setFirstName("Rajesh");
		sdto.setLastName("Patidar");
		sdto.setAddress("Tornod");
		sdto.setLogIn("rajesh");
		sdto.setPassword("rj234");
		
		SessionFactory sf = new Configuration().buildSessionFactory();
		
		Session sn = sf.openSession();
		Transaction ts = sn.beginTransaction();
		sn.save(sdto);
		
		ts.commit();
		sn.close();
	}

}

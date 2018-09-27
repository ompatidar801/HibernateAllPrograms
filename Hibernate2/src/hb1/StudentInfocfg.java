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
		//sdto.setId(2);
		sdto.setFirstName("RaviRaj");
		sdto.setLastName("patidar");
		sdto.setAddress("badnawar");
		sdto.setLogIn("rr");
		sdto.setPassword("rrp2342");
		
		SuppliersDTO spdto = new SuppliersDTO();
		//spdto.setSp_id(5);
		spdto.setSp_name("forma");
		spdto.setSp_address("tamilnadu");
		
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml"); 
		 
		 SessionFactory factory = cfg.buildSessionFactory();
		 Session sn = factory.openSession();
		Transaction ts = sn.beginTransaction();
		/*sn.delete(sdto);
		sn.delete(spdto);*/
		
		sn.save(sdto);
		sn.save(spdto);
		
		/*sn.update(sdto);
		sn.update(spdto);*/
		ts.commit();
		sn.close();
	}

}

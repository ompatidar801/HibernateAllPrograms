package oneToOne8;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonsMoBno 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	
	public static void savePersonsMoBno()
	{
		Session sn = sf.openSession();
		PersonsDTO u = new PersonsDTO();
		u.setPid(89);
		u.setPname("Vijay");
		
		PersonsDTO u1 = new PersonsDTO();
		u1.setPid(90);
		u1.setPname("Ajay");
		
		MobileNoDTO co1 = new MobileNoDTO();
		co1.setMobno(82394738);
		co1.setAdharNo(4357893);
		co1.setPerson(u);
		
		MobileNoDTO co2 = new MobileNoDTO();
		co2.setMobno(98732);
		co2.setAdharNo(98532132);
		co2.setPerson(u1);
		
	
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);

		tr.commit();
		sn.close();
		
	}
	
	public static void deletePersonsMoBno()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		//CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		Query q = sn.createQuery("from MobileNoDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			MobileNoDTO co2 = (MobileNoDTO) it1.next();
			PersonsDTO pr = co2.getPerson();
			sn.delete(co2);
		
		}
		tr1.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		//savePersonsMoBno();
		deletePersonsMoBno();
	}
}

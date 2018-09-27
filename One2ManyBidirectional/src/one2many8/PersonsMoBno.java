package one2many8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		
		MobileNoDTO co1 = new MobileNoDTO();
		co1.setMobno(82394738);
		co1.setAdharNo(4357893);
		
		MobileNoDTO co2 = new MobileNoDTO();
		co2.setMobno(98732);
		co2.setAdharNo(98532132);
		
		MobileNoDTO col3 = new MobileNoDTO();
		col3.setMobno(6684536);
		col3.setAdharNo(9842342);
		
		Set<MobileNoDTO> s = new HashSet<MobileNoDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setMno(s);
		co1.setPerson(u);
		co2.setPerson(u);
		col3.setPerson(u);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(u);
		sn.save(co1);
		tr.commit();
		sn.close();
	}
	
	public static void updatePersonsMoBno()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction();
		
		Query q = sn.createQuery("from MobileNoDTO c1");
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			MobileNoDTO co2 = (MobileNoDTO) it1.next();
			co2.setAdharNo(87458750);
			
			PersonsDTO pr = co2.getPerson();
			pr.setPname("Shubham");
			sn.update(pr);
		
		}
		tr1.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		//savePersonsMoBno();
		updatePersonsMoBno();
	}
}

package many2one8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one5.ChildrenDTO;

public class PersonsMoBno 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void savePersonsMoBno()
	{
		PersonsDTO u = new PersonsDTO();
		u.setPid(89);
		u.setPname("Vijay");
		
		MobileNoDTO co1 = new MobileNoDTO();
		co1.setMobno(82394738);
		co1.setAdharNo(4357893);
		co1.setParentObject(u);
		
		MobileNoDTO co2 = new MobileNoDTO();
		co2.setMobno(98732);
		co2.setAdharNo(98532132);
		co2.setParentObject(u);
		
		MobileNoDTO col3 = new MobileNoDTO();
		col3.setMobno(6684536);
		col3.setAdharNo(9842342);
		col3.setParentObject(u);
	
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
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

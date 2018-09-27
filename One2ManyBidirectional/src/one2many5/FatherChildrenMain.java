package one2many5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FatherChildrenMain
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	public static void saveFatherChildrenMain()
	{
		Session sn = sf.openSession();
		
		FatherDTO u = new FatherDTO();
		u.setFid(985);
		u.setFname("Dhanraj");
		u.setAddress("Dhar");
		
		ChildrenDTO co1 = new ChildrenDTO();
		co1.setCdid(8347);
		co1.setCdname("Jayraj");
		co1.setCdaddress("Indore");
		
		ChildrenDTO co2 = new ChildrenDTO();
		co2.setCdid(5432);
		co2.setCdname("Devraj");
		co2.setCdaddress("Bhopal");
		
		ChildrenDTO col3 = new ChildrenDTO();
		col3.setCdid(5433);
		col3.setCdname("Vijayraj");
		col3.setCdaddress("Ratlam");
		
		Set<ChildrenDTO> s = new HashSet<ChildrenDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setSon(s);
		
		co1.setFather(u);
		co2.setFather(u);
		col3.setFather(u);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(u);
		sn.save(co1);
		tr.commit();
		sn.close();
	}
	
	public static void getFatherChildrenMain()
	{
		Session sn = sf.openSession();
		/*FatherDTO u = (FatherDTO)sn.get(FatherDTO.class, 985);
		System.out.println(u.getFid());
		System.out.println(u.getFname());
		System.out.println(u.getAddress());
		
		Set s= u.getSon();
		Iterator it = s.iterator();
		while(it.hasNext())
		{
		
			ChildrenDTO ch1 = (ChildrenDTO) it.next();
			System.out.println(ch1.getCdid());
			System.out.println(ch1.getCdname());
			System.out.println(ch1.getCdaddress());
		
		}*/
		
		Query q= sn.createQuery("from ChildrenDTO ch");
		
		List<?> l = q.list();
		Iterator<?> it1 = l.iterator();
		while(it1.hasNext())
		{
		
			ChildrenDTO ch1 = (ChildrenDTO) it1.next();
			System.out.println(ch1.getCdid());
			System.out.println(ch1.getCdname());
			System.out.println(ch1.getCdaddress());
			
			FatherDTO f = ch1.getFather();
			System.out.println(f.getFid());
			System.out.println(f.getFname());
			System.out.println(f.getAddress());
		
		}
		
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveFatherChildrenMain();
		getFatherChildrenMain();
		
	}
}

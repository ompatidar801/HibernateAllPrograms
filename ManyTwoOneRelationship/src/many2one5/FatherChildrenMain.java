package many2one5;
import java.util.Iterator;
import java.util.List;


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
		co1.setParentObject(u);
		
		ChildrenDTO co2 = new ChildrenDTO();
		co2.setCdid(5432);
		co2.setCdname("Devraj");
		co2.setCdaddress("Bhopal");
		co2.setParentObject(u);
		
		ChildrenDTO col3 = new ChildrenDTO();
		col3.setCdid(5433);
		col3.setCdname("Vijayraj");
		co2.setCdaddress("Ratlam");
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		sn.close();
	
	}
	
	public static void getFatherChildrenMain()
	{
		Session sn = sf.openSession();
		ChildrenDTO ch1 = (ChildrenDTO)sn.get(ChildrenDTO.class, 8347);
		System.out.println("ChildrenDTO Details");
		System.out.println(ch1.getCdid());
		System.out.println(ch1.getCdname());
		System.out.println(ch1.getCdaddress());
		
		
		FatherDTO u =ch1.getParentObject();
		System.out.println("FatherDTO Details");
		System.out.println(u.getFid());
		System.out.println(u.getFname());
		System.out.println(u.getAddress());
		sn.close();
		
	}
	
	public static void updateFatherChildrenMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		ChildrenDTO co2 = (ChildrenDTO) s2.get(ChildrenDTO.class, 8347);
		FatherDTO u =co2.getParentObject();
		u.setFname("Dharmraj");
		u.setAddress("Dhar");
		co2.setCdname("RaviRaj");
		co2.setCdaddress("Badnavar");
		s2.update(co2);
		
		tr.commit();
		s2.close();
	}
	
	public static void deleteFatherChildrenMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		//CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		Query q = sn.createQuery("from ChildrenDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			ChildrenDTO co2 = (ChildrenDTO) it1.next();
			sn.delete(co2);
		
		}
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveFatherChildrenMain();
		getFatherChildrenMain();
		//updateFatherChildrenMain();
		deleteFatherChildrenMain();
		
	}
}

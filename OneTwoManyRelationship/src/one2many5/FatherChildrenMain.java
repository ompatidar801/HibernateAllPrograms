package one2many5;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FatherChildrenMain
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveFatherChildrenMain()
	{
		FatherDTO u = new FatherDTO();
		u.setFid(985);
		u.setFname("Dhanraj");
		u.setAddress("Dhar");
		
		ChildrenDTO co1 = new ChildrenDTO();
		co1.setCdid(8347);
		co1.setCdname("Jayraj");
		co1.setCdaddress("Indore");
		co1.setForeignCDID(985);
		
		ChildrenDTO co2 = new ChildrenDTO();
		co2.setCdid(5432);
		co2.setCdname("Devraj");
		co2.setCdaddress("Bhopal");
		co2.setForeignCDID(985);
		
		ChildrenDTO col3 = new ChildrenDTO();
		col3.setCdid(5433);
		col3.setCdname("Vijayraj");
		co2.setCdaddress("Ratlam");
		col3.setForeignCDID(985);
		
		Set<ChildrenDTO> s = new HashSet<ChildrenDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setSon(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
	
	}
	
	public static void getFatherChildrenMain()
	{
		FatherDTO u = (FatherDTO)sn.get(FatherDTO.class, 985);
		System.out.println(u.getFid());
		System.out.println(u.getFname());
		System.out.println(u.getAddress());
		
		ChildrenDTO ch1 = (ChildrenDTO)sn.get(ChildrenDTO.class, 8347);
		System.out.println(ch1.getCdid());
		System.out.println(ch1.getCdname());
		System.out.println(ch1.getCdaddress());
		System.out.println(ch1.getForeignCDID());
		
		ChildrenDTO ch2 = (ChildrenDTO)sn.get(ChildrenDTO.class, 5432);
		System.out.println(ch2.getCdid());
		System.out.println(ch2.getCdname());
		System.out.println(ch2.getCdaddress());
		System.out.println(ch2.getForeignCDID());
		
		ChildrenDTO ch3 = (ChildrenDTO)sn.get(ChildrenDTO.class, 5432);
		System.out.println(ch3.getCdid());
		System.out.println(ch3.getCdname());
		System.out.println(ch3.getCdaddress());
		System.out.println(ch3.getForeignCDID());
		
	}
	
	public static void updateFatherChildrenMain()
	{
		ChildrenDTO co2 = new ChildrenDTO();
		co2.setCdid(5432);
		co2.setCdname("RaviRaj");
		co2.setCdaddress("Badnavar");
		co2.setForeignCDID(985);
	}
	
	public static void deleteFatherChildrenMain()
	{
		ChildrenDTO co2 = new ChildrenDTO();
		co2.setCdid(5432);
		
		Transaction trn = sn.beginTransaction();
		
		sn.delete(co2);
		trn.commit();	
	}
	
	public static void main(String[] args) 
	{
		//saveFatherChildrenMain();
		//getFatherChildrenMain();
		//updateFatherChildrenMain();
		deleteFatherChildrenMain();
		sn.close();
	}
}

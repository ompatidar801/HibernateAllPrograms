package many2one3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one.CustomerDTO;
import many2one.VendorDTO;

public class UnivercityCollages
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	public static void saveUnivercityCollages()
	{
		Session sn = sf.openSession();
		UnivercityDTO u = new UnivercityDTO();
		u.setUniversityId(437);
		u.setUniverName("DAVV");
		
		CollagesDTO co1 = new CollagesDTO();
		co1.setCollageId(547);
		co1.setCollageName("P.G.Collage");
		co1.setParentObject(u);
		
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		co2.setCollageName("Arvindo");
		co2.setParentObject(u);
		
		CollagesDTO col3 = new CollagesDTO();
		col3.setCollageId(45);
		col3.setCollageName("LNCT");
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		sn.close();
	}
	
	public static void updateUnivercityCollages()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		CollagesDTO c1 = (CollagesDTO) s2.get(CollagesDTO.class,5432);
		UnivercityDTO v1 = c1.getParentObject();
		v1.setUniverName("RJPV");
		c1.setCollageName("LSA");
		
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void getUnivercityCollages()
	{
		Session sn = sf.openSession();
		CollagesDTO c1 = (CollagesDTO) sn.get(CollagesDTO.class, 5432);
		System.out.println("Customer Details");
		System.out.println("ID: "+c1.getCollageId()+" ");
		System.out.println("Name: "+c1.getCollageName()+" ");
		
		
		UnivercityDTO v1 = c1.getParentObject();
		System.out.println("Vendor Details");
		System.out.print("ID: "+v1.getUniversityId()+" ");
		System.out.print("Name: "+v1.getUniverName()+" ");
		System.out.println("");
		
		sn.close();
		
	}
	
	public static void getUnivercityAllCollages()
	{
		Session sn = sf.openSession();
		Query q = sn.createQuery("from CollagesDTO c");
		
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		CollagesDTO c1 = null;
		while(it1.hasNext())
		{
			 c1= (CollagesDTO) it1.next();
			 	System.out.println("Customer Details");
				System.out.println("ID: "+c1.getCollageId()+" ");
				System.out.println("Name: "+c1.getCollageName()+" ");
		
		}
		UnivercityDTO v1 = c1.getParentObject();
		System.out.println("Vendor Details");
		System.out.print("ID: "+v1.getUniversityId()+" ");
		System.out.print("Name: "+v1.getUniverName()+" ");
		System.out.println("");
		
		sn.close();
		
	}
	
	/*public static void deleteUnivercityCollages()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		
		sn.delete(c1);
		
		tr1.commit();
		sn.close();
	}*/
	
	public static void deleteUnivercityCollages()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		//CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		Query q = sn.createQuery("from CollagesDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			CollagesDTO c1= (CollagesDTO) it1.next();
			sn.delete(c1);
		}
		
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveUnivercityCollages();
		updateUnivercityCollages();
		getUnivercityCollages();
		getUnivercityAllCollages();
		deleteUnivercityCollages();

	}

}

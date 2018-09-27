package one2many;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VendorCustomerMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	public static void saveVendorCustomerMain()
	{
		Session sn = sf.openSession();
		
		VendorDTO ven = new VendorDTO();
		ven.setVid(756);
		ven.setVname("Akhil");
		
		CustomerDTO cust1 = new CustomerDTO();
		cust1.setCid(765);
		cust1.setCname("Sanju");
		
		
		CustomerDTO cust2 = new CustomerDTO();
		cust2.setCid(567);
		cust2.setCname("Golu");
		
		
		CustomerDTO cust3 = new CustomerDTO();
		cust3.setCid(879);
		cust3.setCname("Ammu");
		
		Set<CustomerDTO> s = new HashSet<CustomerDTO>();
		s.add(cust1);
		s.add(cust2);
		s.add(cust3);
		
		ven.setChildren(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(ven);
		tr.commit();
		sn.close();
	}
	
	public static void getAllVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		
		Query qry =sn.createQuery("from VendorDTO v");
		List<?> l=qry.list();
		Iterator<?> it1 = l.iterator();
		 
		while(it1.hasNext())
		{

		VendorDTO v=(VendorDTO) it1.next();
		System.out.println("VendorDTO Details:");
		System.out.println("");
		System.out.println("ID: "+v.getVid()+" ");
		System.out.println("Name: "+v.getVname()+" ");
		 
		
		Set<?> s=v.getChildren();
		Iterator<?> it = s.iterator();
		 
		while(it.hasNext())
		{
		 
			CustomerDTO c = (CustomerDTO) it.next();
			System.out.println("");
			System.out.println("Customer Details:");
			System.out.println("");
			System.out.println(c.getCid()+" ");
			System.out.println(c.getCname()+" ");
			System.out.println(c.getForeignvid()+" ");
			System.out.println("---------------------------");
			
		}
		}
		sn.close();
	}
	
	public static void getVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		
		VendorDTO v=(VendorDTO)sn.get(VendorDTO.class, 756);
		System.out.println("VendorDTO Details:");
		System.out.println("");
		System.out.println("ID: "+v.getVid()+" ");
		System.out.println("Name: "+v.getVname()+" ");
		 
		
		Set<?> s=v.getChildren();
		Iterator<?> it = s.iterator();
		 
		while(it.hasNext())
		{
		 
			CustomerDTO c = (CustomerDTO) it.next();
			System.out.println("");
			System.out.println("Customer Details:");
			System.out.println("");
			System.out.println(c.getCid()+" ");
			System.out.println(c.getCname()+" ");
			System.out.println(c.getForeignvid()+" ");
			System.out.println("---------------------------");
			}
		 
	}
	
	public static void updateVendorCustomerMain()
	{
		Session sn1 = sf.openSession();
		Transaction tr1 = sn1.beginTransaction();
		VendorDTO v1 = (VendorDTO) sn1.get(VendorDTO.class, 756);
		v1.setVname("Tanvi");
		Set<?> s = v1.getChildren();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			CustomerDTO cst = (CustomerDTO) it.next();
			cst.setCid(567);
			cst.setCname("Sanam");
			
			cst.setCid(765);
			cst.setCname("Dev");
			
			cst.setCid(879);
			cst.setCname("kalu"); 
			
			sn1.update(cst);
			
			
		}
		tr1.commit();
		sn1.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveVendorCustomerMain();
		//getVendorAllCustomerMain();
		//getAllVendorAllCustomerMain();
		updateVendorCustomerMain();
		
	}

}

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
		Transaction tr = sn.beginTransaction();

			VendorDTO ven = new VendorDTO();
			ven.setVid(543);
			ven.setVname("Arvind");
			
			CustomerDTO cust1 = new CustomerDTO();
			cust1.setCid(75);
			cust1.setCname("Sanjay");
			
			
			CustomerDTO cust2 = new CustomerDTO();
			cust2.setCid(76);
			cust2.setCname("Gaurav");
			
			
			CustomerDTO cust3 = new CustomerDTO();
			cust3.setCid(77);
			cust3.setCname("Amit");
			
			
			CustomerDTO cust4 = new CustomerDTO();
			cust4.setCid(78);
			cust4.setCname("Yash");
			
			
			Set<CustomerDTO> s = new HashSet<CustomerDTO>();
			s.add(cust1);
			s.add(cust2);
			s.add(cust3);
			s.add(cust4);
			
			ven.setChildren(s);
		
			// for many-to-one
		 
			cust1.setParentObject(ven);
			cust2.setParentObject(ven);
			cust3.setParentObject(ven);
			cust4.setParentObject(ven);
			
			sn.save(ven);
			//sn.save(cust1);
			
			
			tr.commit();
			sn.close();
	}
	
	public static void updateVendorCustomerMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		VendorDTO v3 = (VendorDTO) s2.get(VendorDTO.class, 112);
		Set<?> st4 = v3.getChildren();
		Iterator<?> it = st4.iterator();
		while(it.hasNext())
		{
			CustomerDTO c1 = (CustomerDTO) it.next();
			c1.setCname("Rohit");
			s2.update(c1);
			
			/*CustomerDTO c3 = (CustomerDTO) it.next();
			c3.setCid(51);
			c3.setCname("humayu");
			s2.merge(c3);
			
			CustomerDTO c2 = (CustomerDTO) it.next();
			c2.setCid(52);
			c2.setCname("brajesh");
			s2.merge(c2);*/
			
		}
		
		tr.commit();
		s2.close();
		
	}
	
	public static void getVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		VendorDTO v1 = (VendorDTO) sn.get(VendorDTO.class, 112);
		System.out.println("Vendor Details");
		System.out.print("ID: "+v1.getVid()+" ");
		System.out.print("Name: "+v1.getVname()+" ");
		System.out.println("");
		
		Set<?> s = v1.getChildren();
		Iterator<?> it = s.iterator();
		
		while(it.hasNext())
		{
			CustomerDTO c1 = (CustomerDTO) it.next();
			System.out.println("Customer Details");
			System.out.println("ID: "+c1.getCid()+" ");
			System.out.println("Name: "+c1.getCname()+" ");
			System.out.println("ForeignID: "+c1.getParentObject()+" ");
		}
		
		
		sn.close();
		
	}
	
	public static void getAllVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		Query q = sn.createQuery("from VendorDTO v1");
		System.out.println("Vendor Details");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			VendorDTO ven = (VendorDTO) it1.next();
			System.out.print("ID: "+ven.getVid()+" ");
			System.out.print("Name: "+ven.getVname()+" ");
			System.out.println("");
		
			Set<?> s = ven.getChildren();
			Iterator<?> it = s.iterator();
			
			while(it.hasNext())
			{
				CustomerDTO c1 = (CustomerDTO) it.next();
				System.out.println("Customer Details");
				System.out.println("ID: "+c1.getCid()+" ");
				System.out.println("Name: "+c1.getCname()+" ");
				System.out.println("ForeignID: "+c1.getParentObject()+" ");
			}
			
		}
		sn.close();
		
	}
	
	
	public static void deleteVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		VendorDTO v2 = (VendorDTO) sn.get(VendorDTO.class,112);
		sn.delete(v2);
		
		/*VendorDTO v3 = (VendorDTO) sn.get(VendorDTO.class,112);
		
		Set s1 = v3.getChildren();
		Iterator ir = s1.iterator();
		while(ir.hasNext())
		{
			VendorDTO c1 = (VendorDTO) ir.next();
			
			sn.delete(c1);
		}*/
		tr1.commit();
		sn.close();
	}
	
	public static void deleteAllVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		Query q = sn.createQuery("from VendorDTO v3");
	
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			VendorDTO v3 = (VendorDTO) it1.next();
			sn.delete(v3);
		}
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		saveVendorCustomerMain();
		//updateVendorCustomerMain();
		//getVendorAllCustomerMain();
		//getAllVendorAllCustomerMain();
		//deleteVendorAllCustomerMain();
		//deleteAllVendorAllCustomerMain();
		
	}

}

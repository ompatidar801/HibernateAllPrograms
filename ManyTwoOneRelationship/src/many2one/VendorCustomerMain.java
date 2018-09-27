package many2one;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
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
		try
		{
			VendorDTO ven = new VendorDTO();
			ven.setVid(333);
			ven.setVname("Anil");
			
			CustomerDTO cust1 = new CustomerDTO();
			cust1.setCid(744);
			cust1.setCname("Sanjay");
			cust1.setParentObject(ven);
			
			
			CustomerDTO cust2 = new CustomerDTO();
			cust2.setCid(745);
			cust2.setCname("Gaurav");
			cust2.setParentObject(ven);
			
			CustomerDTO cust3 = new CustomerDTO();
			cust3.setCid(746);
			cust3.setCname("Amit");
			cust3.setParentObject(ven);
			
			CustomerDTO cust4 = new CustomerDTO();
			cust4.setCid(747);
			cust4.setCname("Yash");
			cust4.setParentObject(ven);

			sn.save(cust1);
			sn.save(cust2);
			sn.save(cust3);
			sn.save(cust4);
			tr.commit();
			
		}
		catch (HibernateException e) 
		{
			tr.rollback();
			e.printStackTrace();
		}
		finally 
		{
			sn.close();
		}
	}
	
	public static void updateVendorCustomerMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		CustomerDTO c1 = (CustomerDTO) s2.get(CustomerDTO.class,746);
		VendorDTO v1 = c1.getParentObject();
		v1.setVname("Gandhi");
		c1.setCname("Yogesh");
		
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void getVendorCustomerMain()
	{
		Session sn = sf.openSession();
		CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		System.out.println("Customer Details");
		System.out.println("ID: "+c1.getCid()+" ");
		System.out.println("Name: "+c1.getCname()+" ");
		
		
		VendorDTO v1 = c1.getParentObject();
		System.out.println("Vendor Details");
		System.out.print("ID: "+v1.getVid()+" ");
		System.out.print("Name: "+v1.getVname()+" ");
		System.out.println("");
		
		sn.close();
		
	}
	
	public static void getVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		Query q = sn.createQuery("from CustomerDTO c");
		
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		CustomerDTO c1 = null;
		while(it1.hasNext())
		{
			 c1= (CustomerDTO) it1.next();
			System.out.println("Customer Details");
			System.out.println("ID: "+c1.getCid()+" ");
			System.out.println("Name: "+c1.getCname()+" ");
		
		}
		VendorDTO v1 = c1.getParentObject();
		System.out.println("Vendor Details");
		System.out.print("ID: "+v1.getVid()+" ");
		System.out.print("Name: "+v1.getVname()+" ");
		System.out.println("");
		sn.close();
		
	}
	
	/*public static void deleteVendorCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		
		sn.delete(c1);
		
		tr1.commit();
		sn.close();
	}*/
	
	public static void deleteVendorAllCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		//CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		Query q = sn.createQuery("from CustomerDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			CustomerDTO c1= (CustomerDTO) it1.next();
			sn.delete(c1);
		}
		
		tr1.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		//saveVendorCustomerMain();
		//updateVendorCustomerMain();
		//getVendorCustomerMain();
		//getVendorAllCustomerMain();
		//deleteVendorCustomerMain();
		deleteVendorAllCustomerMain();
		
	}

}

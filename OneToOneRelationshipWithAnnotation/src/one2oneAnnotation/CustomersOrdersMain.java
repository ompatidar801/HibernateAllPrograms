package one2oneAnnotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class CustomersOrdersMain 
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveCustomersOrdersMain()
	{
		Session sn = sf.openSession();
		
		Customers cst1 = new Customers();
		cst1.setCustid(71);
		cst1.setCname("Pradeep");
		cst1.setCadd("Sanavad");
		
		Customers cst2 = new Customers();
		cst2.setCustid(72);
		cst2.setCname("Sandeep");
		cst2.setCadd("Khandwa");
		
		Customers cst3 = new Customers();
		cst3.setCustid(73);
		cst3.setCname("Jaydeep");
		cst3.setCadd("Bhopal");
		
		OrdersOfCustomer odr1 = new OrdersOfCustomer();
		odr1.setOdrId(857478);
		odr1.setProduct("Shoes");
		odr1.setCust(cst1);
		
		OrdersOfCustomer odr2 = new OrdersOfCustomer();
		odr2.setOdrId(875784);
		odr2.setProduct("Jackets");
		odr2.setCust(cst2);
		
		OrdersOfCustomer odr3 = new OrdersOfCustomer();
		odr3.setOdrId(34663);
		odr3.setProduct("JavaBooks");
		odr3.setCust(cst3);
		
		Transaction tr1 = sn.beginTransaction();
		sn.save(odr1);
		sn.save(odr2);
		sn.save(odr3);
		
		tr1.commit();
		sn.close();
		
		
	}
	
	public static void getCustomersOrdersMain()
	{
		Session sn = sf.openSession();
		Query qr = sn.createQuery("from OrdersOfCustomer oc");
		List<?> l = qr.list();
		Iterator<?> itr = l.iterator();
		while(itr.hasNext())
		{
			OrdersOfCustomer oc = (OrdersOfCustomer) itr.next();
			System.out.println("---------OrdersOfCustomer Details-------");
			System.out.println("ID: "+oc.getOdrId());
			System.out.println("Name: "+oc.getProduct());
			System.out.println("---------------------------------");
			
			Customers cust1 = oc.getCust();
			System.out.println("---------Customres Details-------");
			System.out.println("ID: "+cust1.getCustid());
			System.out.println("Name: "+cust1.getCname());
			System.out.println("Address: "+cust1.getCadd());
			System.out.println("---------------------------------");
			
		}
		sn.close();
	}
	
	public static void updateCustomersOrdersMain()
	{
		Session sn = sf.openSession();
		OrdersOfCustomer oc = (OrdersOfCustomer) sn.get(OrdersOfCustomer.class, 857478);
		oc.setProduct("T-shirt");
		
		Customers c1 = oc.getCust();
		c1.setCname("Pradeep");
		c1.setCadd("Banglore");
		
		Transaction tr = sn.beginTransaction();
		sn.update(c1);
		tr.commit();
		sn.close();
		
	}
	
	public static void deleteCustomersOrdersMain()
	{
		Session sn = sf.openSession();
		OrdersOfCustomer oc = (OrdersOfCustomer) sn.get(OrdersOfCustomer.class, 857478);
		Customers c1 = oc.getCust();
		
		Transaction tr = sn.beginTransaction();
		sn.delete(oc);
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCustomersOrdersMain();
		//getCustomersOrdersMain();
		//updateCustomersOrdersMain();
		deleteCustomersOrdersMain();

	}

}

package custom;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerOrdersMain {

	public static void main(String[] args)
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sn = sf.openSession();
		
		Customer2 cst1 = new Customer2();
		cst1.setCustID(101);
		cst1.setCustName("Kavi");
		cst1.setCustAddress("Rau");
		cst1.setCreatedBy(new Date());
		cst1.setUpdatedBy(new Date());
		
		Customer2 cst2 = new Customer2();
		cst2.setCustID(102);
		cst2.setCustName("Mahesh");
		cst2.setCustAddress("Sagwal");
		cst2.setCreatedBy(new Date());
		cst2.setUpdatedBy(new Date());
		
		CustomerOrders co1 = new CustomerOrders();
		co1.setCust_orderID(76437);
		co1.setCreatedBy(new Date());
		co1.setUpdatedBy(new Date());
		co1.setFkcustID(101);
		
		CustomerOrders co2 = new CustomerOrders();
		co2.setCust_orderID(3645);
		co2.setCreatedBy(new Date());
		co2.setUpdatedBy(new Date());
		co2.setFkcustID(102);
		
		CustomerOrders co3 = new CustomerOrders();
		co3.setCust_orderID(9586);
		co3.setCreatedBy(new Date());
		co3.setUpdatedBy(new Date());
		co3.setFkcustID(101);
		
		Set<CustomerOrders> s = new HashSet<CustomerOrders>();
		s.add(co1);
		s.add(co2);
		s.add(co3);
		
		cst1.setCust_ord(s);
		cst2.setCust_ord(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(cst1);
		sn.save(cst2);
		tr.commit();
		sn.close();
		
	}

}

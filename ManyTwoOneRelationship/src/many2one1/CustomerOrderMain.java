package many2one1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one.CustomerDTO;
import many2one.VendorDTO;

public class CustomerOrderMain 
{
	static SessionFactory sf1 = new Configuration().configure().buildSessionFactory();
	
	public static void saveCustomerOrderMain()
	{
		
		Session sn = sf1.openSession();
		CustomerDTO2 cst2 = new CustomerDTO2();
		cst2.setCstid(342);
		cst2.setCustname("Lovin");
		cst2.setPhoneno(364234703);
		
		OrderDTO ord = new OrderDTO();
		ord.setOrderId(233530);
		ord.setProduct("Java Book");
		ord.setParentObject(cst2);
		
		OrderDTO ord1 = new OrderDTO();
		ord1.setOrderId(874365);
		ord1.setProduct("C++ Book");
		ord1.setParentObject(cst2);
		
		OrderDTO ord2 = new OrderDTO();
		ord2.setOrderId(5647);
		ord2.setProduct("Laptop");
		ord2.setParentObject(cst2);
		
		OrderDTO ord3 = new OrderDTO();
		ord3.setOrderId(96878);
		ord3.setProduct("Black Book");
		ord3.setParentObject(cst2);
		
		Transaction t1 = sn.beginTransaction();
		sn.save(ord);
		sn.save(ord1);
		sn.save(ord2);
		sn.save(ord3);
		t1.commit();
		sn.close();
	}
	
	public static void updateCustomerOrderMain()
	{
		Session s2 = sf1.openSession();
		Transaction tr = s2.beginTransaction();
		OrderDTO od1 = (OrderDTO ) s2.get(OrderDTO.class,5647);
		CustomerDTO2 cd1 = od1.getParentObject();
		cd1.setCustname("parth");
		od1.setProduct("Yoga Book");
		
		s2.update(od1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void getCustomerOrderMain()
	{
		Session sn = sf1.openSession();
		
		OrderDTO or1 = (OrderDTO) sn.get(OrderDTO.class,5647);
		System.out.println("Order Details");
		System.out.print("ID:"+or1.getOrderId()+" ");
		System.out.print("Product:"+or1.getProduct()+" ");
		System.out.println("");
		
		CustomerDTO2 cst1 = or1.getParentObject();
		System.out.println("Customer Details");
		System.out.print("ID:"+cst1.getCstid()+" ");
		System.out.print("Name:"+cst1.getCustname()+" ");
		System.out.print("Phone No:"+cst1.getPhoneno()+" ");
		System.out.println("");
		sn.close();
		
	}
	
	public static void getCustomerAllOrderMain()
	{
		Session sn = sf1.openSession();
		Query q = sn.createQuery("from OrderDTO o");
		List l =q.list();
		Iterator ir = l.iterator();
		OrderDTO or1 = null;
		while(ir.hasNext())
		{
			or1 = (OrderDTO) ir.next();
			System.out.println("Order Details");
			System.out.print("ID:"+or1.getOrderId()+" ");
			System.out.print("Product:"+or1.getProduct()+" ");
			System.out.println("");
		}
		CustomerDTO2 cst1 = or1.getParentObject();
		System.out.println("Customer Details");
		System.out.print("ID:"+cst1.getCstid()+" ");
		System.out.print("Name:"+cst1.getCustname()+" ");
		System.out.print("Phone No:"+cst1.getPhoneno()+" ");
		System.out.println("");
		sn.close();
		
	}
	
	public static void deleteCustomerOrderMain()
	{
		Session sn = sf1.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		Query q = sn.createQuery("from OrderDTO o");
		List l =q.list();
		Iterator ir = l.iterator();
		while(ir.hasNext())
		{
			OrderDTO or1 = (OrderDTO) ir.next();
			sn.delete(or1);
		}
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCustomerOrderMain();
		//updateCustomerOrderMain();
		//getCustomerOrderMain();
		//getCustomerAllOrderMain();
		deleteCustomerOrderMain();
		
	}

}

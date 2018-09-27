package manyToMany1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerOrderMain 
{
	static SessionFactory sf1 = new Configuration().configure().buildSessionFactory(); 
	
	public static void saveCustomerOrderMain()
	{
		
		Session sn = sf1.openSession();
		CustomerDTO2 cst2 = new CustomerDTO2();
		cst2.setCstid(342);
		cst2.setCustname("prasant");
		cst2.setPhoneno(364234703);
		
		CustomerDTO2 cst3 = new CustomerDTO2();
		cst3.setCstid(343);
		cst3.setCustname("YashRaj");
		cst3.setPhoneno(8574893);
		
		OrderDTO ord = new OrderDTO();
		ord.setOrderId(233530);
		ord.setProduct("Java Book");
		
		
		OrderDTO ord1 = new OrderDTO();
		ord1.setOrderId(874365);
		ord1.setProduct("C++ Book");
		
		
		OrderDTO ord2 = new OrderDTO();
		ord2.setOrderId(5647);
		ord2.setProduct("Laptop");
		
		
		OrderDTO ord3 = new OrderDTO();
		ord3.setOrderId(96878);
		ord3.setProduct("Black Book");
		
		
		Set<OrderDTO> st = new HashSet<OrderDTO>();
		st.add(ord);
		st.add(ord1);
		st.add(ord2);
		st.add(ord3);
		
		cst2.setOrder(st);
		cst3.setOrder(st);
		
		
		Transaction t1 = sn.beginTransaction();
		sn.save(cst2);
		sn.save(cst3);
		t1.commit();
		sn.close();
		
	}
	public static void getCustomerOrderMain()
	{
		Session sn = sf1.openSession();
		CustomerDTO2 cst1 = (CustomerDTO2) sn.get(CustomerDTO2.class,342);
		System.out.println("------Customer Detalis------");
		System.out.print("ID:"+cst1.getCstid()+" ");
		System.out.print("Name:"+cst1.getCustname()+" ");
		System.out.print("PhoneNo:"+cst1.getPhoneno()+" ");
		System.out.println("----------------------------");
		
		Set<?> s = cst1.getOrder();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			OrderDTO or1 = (OrderDTO) it.next();
			System.out.println("------Order Detalis------");
			System.out.print("ID:"+or1.getOrderId()+" ");
			System.out.print("Product:"+or1.getProduct()+" ");
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
			System.out.println("----------------------------");
	
		}
		
		OrderDTO or2 = (OrderDTO) sn.get(OrderDTO.class, 5647);
		System.out.println("------Order Detalis------");
		System.out.print("ID"+or2.getOrderId()+" ");
		System.out.print("Product:"+or2.getProduct()+" ");
		System.out.println("----------------------------");
		
		
		Set<?> s1 =or2.getCustomer();
		Iterator<?> it1 = s1.iterator();
		while(it1.hasNext())
		{
			CustomerDTO2 c2 = (CustomerDTO2) it1.next();
			System.out.println("------Customer Detalis------");
			System.out.print("ID:"+c2.getCstid()+" ");
			System.out.print("Name"+c2.getCustname()+" ");
			System.out.print("PhoneNo:"+c2.getPhoneno()+" ");                                                
			System.out.println("----------------------------");                                                        
		}
		
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCustomerOrderMain();
		getCustomerOrderMain();
		
	}

}

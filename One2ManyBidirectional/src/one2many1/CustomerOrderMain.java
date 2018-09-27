package one2many1;

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
		
		cst2.setChild(st);
		
		//many-to-one
		ord.setParentObject(cst2);
		ord1.setParentObject(cst2);
		ord2.setParentObject(cst2);
		ord3.setParentObject(cst2);
		
		Transaction t1 = sn.beginTransaction();
		sn.save(cst2);
		//sn.save(ord);
		t1.commit();
		sn.close();
		
	}
	public static void getCustomerOrderMain()
	{
		Session sn = sf1.openSession();
		/*CustomerDTO2 cst1 = (CustomerDTO2) sn.get(CustomerDTO2.class,342);
		System.out.print("ID:"+cst1.getCstid()+" ");
		System.out.print("Name"+cst1.getCustname()+" ");
		System.out.print("PhoneNo:"+cst1.getPhoneno()+" ");
		System.out.println("");
		
		Set<?> s = cst1.getChild();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			OrderDTO or1 = (OrderDTO) it.next();
			System.out.print("ID"+or1.getOrderId()+" ");
			System.out.print("Product:"+or1.getProduct()+" ");
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
			System.out.println("");
	
		}
		*/
		OrderDTO or2 = (OrderDTO) sn.get(OrderDTO.class, 5647);
		System.out.print("ID"+or2.getOrderId()+" ");
		System.out.print("Product:"+or2.getProduct()+" ");
		
		System.out.println("");
		
		
		CustomerDTO2 cst2 =or2.getParentObject();
		System.out.print("ID:"+cst2.getCstid()+" ");
		System.out.print("Name"+cst2.getCustname()+" ");
		System.out.print("PhoneNo:"+cst2.getPhoneno()+" ");                                                
		System.out.println("");                                                         
		
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCustomerOrderMain();
		getCustomerOrderMain();
		
	}

}

package one2many1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerOrderMain 
{
	static SessionFactory sf1 = new Configuration().configure().buildSessionFactory();
	static Session sn = sf1.openSession();
	
	public static void saveCustomerOrderMain()
	{
		
		
		CustomerDTO2 cst2 = new CustomerDTO2();
		cst2.setCstid(342);
		cst2.setCustname("Lovin");
		cst2.setPhoneno(364234703);
		
		OrderDTO ord = new OrderDTO();
		ord.setOrderId(233530);
		ord.setProduct("Java Book");
		ord.setForeignCustId(342);
		
		OrderDTO ord1 = new OrderDTO();
		ord1.setOrderId(874365);
		ord1.setProduct("C++ Book");
		ord1.setForeignCustId(342);
		
		OrderDTO ord2 = new OrderDTO();
		ord2.setOrderId(5647);
		ord2.setProduct("Laptop");
		ord2.setForeignCustId(342);
		
		OrderDTO ord3 = new OrderDTO();
		ord3.setOrderId(96878);
		ord3.setProduct("Black Book");
		ord3.setForeignCustId(342);
		
		Set<OrderDTO> st = new HashSet<OrderDTO>();
		st.add(ord);
		st.add(ord1);
		st.add(ord2);
		st.add(ord3);
		
		cst2.setChild(st);
		
		Transaction t1 = sn.beginTransaction();
		sn.save(cst2);
		t1.commit();
		
	}
	public static void getCustomerOrderMain()
	{
		CustomerDTO2 cst1 = (CustomerDTO2) sn.get(CustomerDTO2.class,342);
		System.out.print(cst1.getCstid()+" ");
		System.out.print(cst1.getCustname()+" ");
		System.out.print(cst1.getPhoneno()+" ");
		System.out.println("");
		
		
		OrderDTO or1 = (OrderDTO) sn.get(OrderDTO.class,5647);
		System.out.print(or1.getOrderId()+" ");
		System.out.print(or1.getProduct()+" ");
		System.out.print(or1.getForeignCustId()+" ");
		System.out.println("");
	
		OrderDTO or2 = (OrderDTO) sn.get(OrderDTO.class,233530);
		System.out.print(or2.getOrderId()+" ");
		System.out.print(or2.getProduct()+" ");
		System.out.print(or2.getForeignCustId()+" ");
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		//saveCustomerOrderMain();
		getCustomerOrderMain();
		sn.close();
	}

}

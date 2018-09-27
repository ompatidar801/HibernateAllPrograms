package oneToOne3;

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
		ord.setCustomer(cst2);
		
		OrderDTO ord1 = new OrderDTO();
		ord1.setOrderId(874365);
		ord1.setProduct("C++ Book");
		ord1.setCustomer(cst3);
		
		Transaction t1 = sn.beginTransaction();
		sn.save(ord);
		sn.save(ord1);
		t1.commit();
		sn.close();
		
	}
	public static void getCustomerOrderMain()
	{
		Session sn = sf1.openSession();
		
		OrderDTO or2 = (OrderDTO) sn.get(OrderDTO.class, 342);
		System.out.println("------Order Detalis------");
		System.out.print("ID:"+or2.getOrderId()+" ");
		System.out.print("Product:"+or2.getProduct()+" ");
		System.out.println("----------------------------");
		
		
			CustomerDTO2 c2 =or2.getCustomer();
			System.out.println("------Customer Detalis------");
			System.out.print("ID:"+c2.getCstid()+" ");
			System.out.print("Name"+c2.getCustname()+" ");
			System.out.print("PhoneNo:"+c2.getPhoneno()+" ");                                                
			System.out.println("----------------------------");                                                        
		
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCustomerOrderMain();
		getCustomerOrderMain();
		
	}

}

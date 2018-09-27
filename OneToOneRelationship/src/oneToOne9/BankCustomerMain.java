package oneToOne9;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BankCustomerMain
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	
	public static void saveBankCustomerMain()
	{
		Session sn = sf.openSession();
		BankDTO u = new BankDTO();
		u.setBranchCode(84357);
		u.setBankName("SBI");
		
		BankDTO u1 = new BankDTO();
		u1.setBranchCode(84342);
		u1.setBankName("BOI");
		
		BankCustomerDTO co1 = new BankCustomerDTO();
		co1.setCstid(8454);
		co1.setCustname("Tinku");
		co1.setPhoneno(93458);
		co1.setBank(u);
		
		BankCustomerDTO co2 = new BankCustomerDTO();
		co2.setCstid(98732);
		co2.setCustname("yogendra");
		co2.setPhoneno(348573);
		co2.setBank(u1);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		
		tr.commit();
		sn.close();
	}
	
	public static void updateBankCustomerMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		BankCustomerDTO c1 = (BankCustomerDTO) s2.get(BankCustomerDTO.class,84342);
		BankDTO v1 = c1.getBank();
		v1.setBankName("BOM");
		c1.setCustname("parth");
		
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void deleteBankCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		BankDTO u = new BankDTO();
		u.setBranchCode(84357);
		
		BankCustomerDTO co1 = new BankCustomerDTO();
		co1.setCstid(8454);
		co1.setBank(u);
		
		sn.delete(co1);
		
		/*Query q = sn.createQuery("from BankCustomerDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			BankCustomerDTO co2 = (BankCustomerDTO) it1.next();
			BankDTO b = co2.getBank();
			
			sn.delete(co2);
		
		}*/
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveBankCustomerMain();
		//updateBankCustomerMain();
		deleteBankCustomerMain();
	}
}

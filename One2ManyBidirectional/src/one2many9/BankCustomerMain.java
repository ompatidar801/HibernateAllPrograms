package one2many9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		
		BankCustomerDTO co1 = new BankCustomerDTO();
		co1.setCstid(8454);
		co1.setCustname("Tinku");
		co1.setPhoneno(93458);
		
		BankCustomerDTO co2 = new BankCustomerDTO();
		co2.setCstid(98732);
		co2.setCustname("yogendra");
		co2.setPhoneno(348573);
		
		BankCustomerDTO col3 = new BankCustomerDTO();
		col3.setCstid(6684536);
		col3.setCustname("umesh");
		col3.setPhoneno(96852);
		
		Set<BankCustomerDTO> s = new HashSet<BankCustomerDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setBkCust(s);
		
		co1.setBank(u);
		co2.setBank(u);
		col3.setBank(u);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(u);
		sn.save(co2);
		tr.commit();
		sn.close();
	}
	
	public static void deleteBankCustomerMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 

		Query q = sn.createQuery("from BankCustomerDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			BankCustomerDTO co2 = (BankCustomerDTO) it1.next();
			BankDTO bd = co2.getBank();
			sn.delete(bd);
		
		}
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveBankCustomerMain();
		deleteBankCustomerMain();
	}
}

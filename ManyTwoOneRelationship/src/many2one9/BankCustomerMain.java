package many2one9;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import many2one6.CoursesDTO;
import many2one6.SchoolDTO;

public class BankCustomerMain
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveBankCustomerMain()
	{
		BankDTO u = new BankDTO();
		u.setBranchCode(84357);
		u.setBankName("SBI");
		
		BankCustomerDTO co1 = new BankCustomerDTO();
		co1.setCstid(8454);
		co1.setCustname("Tinku");
		co1.setPhoneno(93458);
		co1.setParentObject(u);
		
		BankCustomerDTO co2 = new BankCustomerDTO();
		co2.setCstid(98732);
		co2.setCustname("yogendra");
		co2.setPhoneno(348573);
		co2.setParentObject(u);
		
		BankCustomerDTO col3 = new BankCustomerDTO();
		col3.setCstid(6684536);
		col3.setCustname("umesh");
		col3.setPhoneno(96852);
		col3.setParentObject(u);
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		sn.close();
	}
	
	public static void updateBankCustomerMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		BankCustomerDTO c1 = (BankCustomerDTO) s2.get(BankCustomerDTO.class,8454);
		BankDTO v1 = c1.getParentObject();
		v1.setBankName("BOI");
		c1.setCustname("parth");
		
		s2.update(c1);
		
		tr.commit();
		s2.close();
		
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
			sn.delete(co2);
		
		}
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveBankCustomerMain();
		updateBankCustomerMain();
		deleteBankCustomerMain();
	}
}

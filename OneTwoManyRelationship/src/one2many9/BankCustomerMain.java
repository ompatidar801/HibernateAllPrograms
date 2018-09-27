package one2many9;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		co1.setForeignBID(84357);
		
		BankCustomerDTO co2 = new BankCustomerDTO();
		co2.setCstid(98732);
		co2.setCustname("yogendra");
		co2.setPhoneno(348573);
		co2.setForeignBID(84357);
		
		BankCustomerDTO col3 = new BankCustomerDTO();
		col3.setCstid(6684536);
		col3.setCustname("umesh");
		col3.setPhoneno(96852);
		col3.setForeignBID(84357);
		
		Set<BankCustomerDTO> s = new HashSet<BankCustomerDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setBkCust(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		saveBankCustomerMain();
	}
}

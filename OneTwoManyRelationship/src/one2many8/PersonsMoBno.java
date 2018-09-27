package one2many8;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonsMoBno 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void savePersonsMoBno()
	{
		PersonsDTO u = new PersonsDTO();
		u.setPid(89);
		u.setPname("Vijay");
		
		MobileNoDTO co1 = new MobileNoDTO();
		co1.setMobno(82394738);
		co1.setAdharNo(4357893);
		co1.setForeignPNO(89);
		
		MobileNoDTO co2 = new MobileNoDTO();
		co2.setMobno(98732);
		co2.setAdharNo(98532132);
		co2.setForeignPNO(89);
		
		MobileNoDTO col3 = new MobileNoDTO();
		col3.setMobno(6684536);
		col3.setAdharNo(9842342);
		col3.setForeignPNO(89);
		
		Set<MobileNoDTO> s = new HashSet<MobileNoDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setMno(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
	}
	
	public static void updatePersonsMoBno()
	{
		MobileNoDTO co1 = new MobileNoDTO();
		co1.setMobno(82394738);
		co1.setAdharNo(93423427);
		co1.setForeignPNO(89);
		
		Transaction tr = sn.beginTransaction();
		sn.update(co1);
		
		tr.commit();
		
	}
	public static void main(String[] args) 
	{
		//savePersonsMoBno();
		updatePersonsMoBno();
	}
}

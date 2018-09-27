package one2many3;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UnivercityCollages
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveUnivercityCollages()
	{
		UnivercityDTO u = new UnivercityDTO();
		u.setUniversityId(437);
		u.setUniverName("DAVV");
		
		CollagesDTO co1 = new CollagesDTO();
		co1.setCollageId(547);
		co1.setCollageName("rani");
		co1.setForeignCID(437);
		
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		co2.setCollageName("rohit");
		co2.setForeignCID(437);
		
		CollagesDTO col3 = new CollagesDTO();
		col3.setCollageId(45);
		col3.setCollageName("fezal");
		col3.setForeignCID(437);
		
		Set<CollagesDTO> s = new HashSet<CollagesDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setCollege(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		sn.close();
	}
	
	public static void deleteUnivercityCollages()
	{
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		Transaction trn = sn.beginTransaction();
		
		sn.delete(co2);
		trn.commit();
		
	}
	public static void main(String[] args) 
	{
		//saveUnivercityCollages();
		deleteUnivercityCollages();
		sn.close();
	}

}

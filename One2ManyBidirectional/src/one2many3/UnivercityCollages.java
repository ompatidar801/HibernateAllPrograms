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
 
	public static void saveUnivercityCollages()
	{
		Session sn = sf.openSession();
		UnivercityDTO u = new UnivercityDTO();
		u.setUniversityId(437);
		u.setUniverName("DAVV");
		
		CollagesDTO co1 = new CollagesDTO();
		co1.setCollageId(547);
		co1.setCollageName("P.G.Collage");
		
		
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		co2.setCollageName("Arvindo");
		
		
		CollagesDTO col3 = new CollagesDTO();
		col3.setCollageId(45);
		col3.setCollageName("LNCT");
		
		Set<CollagesDTO> s = new HashSet<CollagesDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setCollege(s);
		
		//for many to one
		co1.setParentObject(u);
		co2.setParentObject(u);
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		/*sn.save(co1);
		sn.save(co2);
		sn.save(col3);*/
		
		sn.save(u);
		tr.commit();
		sn.close();
	}
	
	public static void deleteUnivercityCollages()
	{
		Session sn = sf.openSession();
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		Transaction trn = sn.beginTransaction();
		
		sn.delete(co2);
		trn.commit();
		
	}
	public static void main(String[] args) 
	{
		saveUnivercityCollages();
		//deleteUnivercityCollages();
		
	}

}

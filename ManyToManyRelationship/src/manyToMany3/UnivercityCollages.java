package manyToMany3;

import java.util.HashSet;
import java.util.Iterator;
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
		
		UnivercityDTO u1 = new UnivercityDTO();
		u1.setUniversityId(438);
		u1.setUniverName("RJPV");
		
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
		u1.setCollege(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		sn.save(u1);		
		tr.commit();
		sn.close();
	}
	
	public static void deleteUnivercityCollages()
	{
		Session sn = sf.openSession();
		Transaction trn = sn.beginTransaction();
		/*CollagesDTO co2 = (CollagesDTO) sn.get(CollagesDTO.class, 5432);
		Set s1 = co2.getUnivercity();
		Iterator it = s1.iterator();
		while(it.hasNext())
		{
			UnivercityDTO ud = (UnivercityDTO) it.next();
			
			sn.delete(ud);
		}*/
		
		UnivercityDTO ue = (UnivercityDTO) sn.get(UnivercityDTO.class, 437);
		//sn.delete(ue);
		Set s7 = ue.getCollege();
		Iterator itr = s7.iterator();
		while(itr.hasNext())
		{
			CollagesDTO cd = (CollagesDTO) itr.next();
			sn.delete(cd);
		}
		trn.commit();
		sn.close();
		
	}
	public static void main(String[] args) 
	{
		//saveUnivercityCollages();
		deleteUnivercityCollages();
		
	}

}

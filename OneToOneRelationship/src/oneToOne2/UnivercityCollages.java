package oneToOne2;

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
		
		UnivercityDTO u1 = new UnivercityDTO();
		u1.setUniversityId(438);
		u1.setUniverName("Makhanlal");
		
		CollagesDTO co1 = new CollagesDTO();
		co1.setCollageId(547);
		co1.setCollageName("P.G.collage");
		co1.setUniver(u);
		
		CollagesDTO co2 = new CollagesDTO();
		co2.setCollageId(5432);
		co2.setCollageName("Arvindo");
		co2.setUniver(u1);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		
		tr.commit();
		sn.close();
	}
	
	public static void deleteUnivercityCollages()
	{
		Session sn = sf.openSession();
		CollagesDTO cd = (CollagesDTO) sn.get(CollagesDTO.class, 437);
		UnivercityDTO uni = cd.getUniver();
		Transaction trn = sn.beginTransaction();
		
		sn.delete(cd);
		trn.commit();
		sn.close();
	}
	public static void main(String[] args) 
	{
		//saveUnivercityCollages();
		deleteUnivercityCollages();
		
	}

}

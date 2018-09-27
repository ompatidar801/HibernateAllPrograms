package manyToMany7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MobileCompanyMOdels
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	
	public static void saveMobileCompanyMOdels()
	{
		Session sn = sf.openSession();
		MobileCompanyDTO u = new MobileCompanyDTO();
		u.setCompanyID(958);
		u.setComName("Xiaomi");
		
		MobileCompanyDTO u1 = new MobileCompanyDTO();
		u1.setCompanyID(959);
		u1.setComName("samsung");
		
		ModelsDTO co1 = new ModelsDTO();
		co1.setModelNO(444);
		co1.setModelName("A1");
		
		ModelsDTO co2 = new ModelsDTO();
		co2.setModelNO(555);
		co2.setModelName("Redmi4");
		
		ModelsDTO col3 = new ModelsDTO();
		col3.setModelNO(666);
		col3.setModelName("MiMAX");
		
		Set<ModelsDTO> s= new HashSet<ModelsDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setModels(s);
		u1.setModels(s);
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		sn.save(u1);
		
		tr.commit();
		sn.close();
		
	}
	public static void getMobileCompanyMOdels()
	{
		Session sn = sf.openSession();
		ModelsDTO or1 = (ModelsDTO) sn.get(ModelsDTO.class,444);
		System.out.print(or1.getModelNO()+" ");
		System.out.print(or1.getModelName()+" ");

		System.out.println("");
	
		Set<?> st1 = or1.getMobCompany();
		Iterator<?> it3 = st1.iterator();
		while(it3.hasNext())
		{
			MobileCompanyDTO mb = (MobileCompanyDTO) it3.next();
			System.out.print(mb.getCompanyID()+" ");
			System.out.print(mb.getComName()+" ");
			
			System.out.println("");
		}
		
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveMobileCompanyMOdels();
		getMobileCompanyMOdels();
		
	}

}

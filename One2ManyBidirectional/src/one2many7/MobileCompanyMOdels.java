package one2many7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
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
		
		ModelsDTO co1 = new ModelsDTO();
		co1.setModelNO(444);
		co1.setModelName("A1");
		
		ModelsDTO co2 = new ModelsDTO();
		co2.setModelNO(555);
		co2.setModelName("Redmi4");
		
		ModelsDTO col3 = new ModelsDTO();
		col3.setModelNO(666);
		col3.setModelName("MiMAX");
		
		Set<ModelsDTO> s = new HashSet<ModelsDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setModel(s);
		
		co1.setCompany(u);
		co2.setCompany(u);
		col3.setCompany(u);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(u);
		sn.save(co1);
		tr.commit();
		sn.close();
		
	}
	public static void getMobileCompanyMOdels()
	{
		Session sn = sf.openSession();
		MobileCompanyDTO cst1 = (MobileCompanyDTO) sn.get(MobileCompanyDTO.class,958);
		System.out.print(cst1.getCompanyID()+" ");
		System.out.print(cst1.getComName()+" ");
		
		System.out.println("");
		
		Set<?> ss = cst1.getModel();
		Iterator<?> itr = ss.iterator();
		while (itr.hasNext()) 
		{
			ModelsDTO md = (ModelsDTO) itr.next();
			System.out.print(md.getModelNO()+" ");
			System.out.print(md.getModelName()+" ");
			System.out.println("");
		}
		
		Query q = sn.createQuery("from ModelsDTO m ");
		List<?> l = q.list();
		Iterator<?> it1 = l.iterator();
		while(it1.hasNext())
		{
		
			ModelsDTO or2 = (ModelsDTO) it1.next();
			System.out.print(or2.getModelNO()+" ");
			System.out.print(or2.getModelName()+" ");
			System.out.println("");
			
			MobileCompanyDTO cst2 = or2.getCompany();
			System.out.print(cst2.getCompanyID()+" ");
			System.out.print(cst2.getComName()+" ");
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

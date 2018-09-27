package one2many4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CountryCitiesMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	public static void saveCountryCitiesMain()
	{
		Session sn = sf.openSession();
		CountryDTO cu = new CountryDTO();
		cu.setCountryCode(437);
		cu.setCountryName("India");
		
		
		CitiesDTO ci1 = new CitiesDTO();
		ci1.setCityCode(547);
		ci1.setCityName("Indore");
		
		
		CitiesDTO ci2 = new CitiesDTO();
		ci2.setCityCode(5343);
		ci2.setCityName("Gao");
		
		CitiesDTO ci3 = new CitiesDTO();
		ci3.setCityCode(4332);
		ci3.setCityName("Manali");
		
		Set<CitiesDTO> s =new HashSet<CitiesDTO>();
		s.add(ci1);
		s.add(ci2);
		s.add(ci3);
		
		cu.setCities(s);
		
		ci1.setParentObject(cu);
		ci2.setParentObject(cu);
		ci3.setParentObject(cu);
		
		Transaction tr = sn.beginTransaction();
		sn.save(ci1);
		//sn.save(cu);
		
		tr.commit();
		sn.close();
	}
	
	public static void deleteCountryCitiesMain()
	{
		Session sn = sf.openSession();
		Transaction trn = sn.beginTransaction();
		//one to many
		/*CountryDTO cu5 =(CountryDTO) sn.get(CountryDTO.class, 437);
		sn.delete(cu5);
				*/
		//many to one
		Query q = sn.createQuery("from CitiesDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			CitiesDTO c1= (CitiesDTO) it1.next();
			sn.delete(c1);
		}
		
		trn.commit();
		sn.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveCountryCitiesMain();
		deleteCountryCitiesMain();
	}

}

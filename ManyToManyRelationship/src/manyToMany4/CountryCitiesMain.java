package manyToMany4;

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
			CountryDTO u = new CountryDTO();
			u.setCountryCode(4874);
			u.setCountryName("India");
			
			CountryDTO u1 = new CountryDTO();
			u1.setCountryCode(4875);
			u1.setCountryName("Pakistan");
			
			CitiesDTO co1 = new CitiesDTO();
			co1.setCityCode(547);
			co1.setCityName("Mumbai");
			
			
			CitiesDTO co2 = new CitiesDTO();
			co2.setCityCode(5432);
			co2.setCityName("Delhi");
			
			
			CitiesDTO col3 = new CitiesDTO();
			col3.setCityCode(3453);
			col3.setCityName("Indore");
			
			Set s =new HashSet();
			s.add(co1);
			s.add(co2);
			s.add(col3);
			
			u.setCities(s);
			u1.setCities(s);
			
			Transaction tr = sn.beginTransaction();
			sn.save(u);
			sn.save(u1);
			
			tr.commit();
			sn.close();
		}
		
		public static void deleteCountryCitiesMain()
		{
			Session sn = sf.openSession();
			Transaction tr1 = sn.beginTransaction(); 
			
			Query q = sn.createQuery("from CitiesDTO c1");
			
			List<?> l = q.list();
			Iterator<?> it1  = l.iterator();
			while(it1.hasNext())
			{
				CitiesDTO c1= (CitiesDTO) it1.next();
				sn.delete(c1);
			}
			
			tr1.commit();
			sn.close();
			
		}
		
		public static void main(String[] args) 
		{
			//saveCountryCitiesMain();
			deleteCountryCitiesMain();
		}

}

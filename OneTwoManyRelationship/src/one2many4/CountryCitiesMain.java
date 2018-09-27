package one2many4;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CountryCitiesMain 
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveCountryCitiesMain()
	{
		CountryDTO u = new CountryDTO();
		u.setCountryCode(4874);
		u.setCountryName("India");
		
		CitiesDTO co1 = new CitiesDTO();
		co1.setCityCode(547);
		co1.setCityName("Mumbai");
		co1.setForeignCityID(4874);
		
		CitiesDTO co2 = new CitiesDTO();
		co2.setCityCode(5432);
		co2.setCityName("Delhi");
		co2.setForeignCityID(4874);
		
		CitiesDTO col3 = new CitiesDTO();
		col3.setCityCode(3453);
		col3.setCityName("Indore");
		col3.setForeignCityID(4874);
		
		Set<CitiesDTO> s = new HashSet<CitiesDTO>();
		s.add(co1);
		s.add(co2);
		s.add(col3);
		
		u.setCities(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(u);
		tr.commit();
		sn.close();
	}
	
	public static void deleteCountryCitiesMain()
	{
		CitiesDTO col3 = new CitiesDTO();
		col3.setCityCode(3453);
		Transaction trn = sn.beginTransaction();
		
		sn.delete(col3);
		trn.commit();
		
	}
	
	public static void main(String[] args) 
	{
		//saveCountryCitiesMain();
		deleteCountryCitiesMain();
	}

}

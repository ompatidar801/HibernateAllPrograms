package oneToOne7;

import java.util.Date;
import java.util.HashSet;
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
		Session	sn = sf.openSession();
		MobileCompanyDTO u = new MobileCompanyDTO();
		u.setCompanyID(958);
		u.setComName("Xiaomi");
		
		MobileCompanyDTO u1 = new MobileCompanyDTO();
		u1.setCompanyID(959);
		u1.setComName("samsung");
		
		ModelsDTO co1 = new ModelsDTO();
		co1.setModelNO(444);
		co1.setModelName("A1");
		co1.setMobCompany(u);
		
		ModelsDTO co2 = new ModelsDTO();
		co2.setModelNO(555);
		co2.setModelName("Redmi4");
		co2.setMobCompany(u1);
	
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		
		tr.commit();
		sn.close();
	}
	public static void getMobileCompanyMOdels()
	{
		Session sn =sf.openSession();
		ModelsDTO or1 = (ModelsDTO) sn.get(ModelsDTO.class,958);
		System.out.print(or1.getModelNO()+" ");
		System.out.print(or1.getModelName()+" ");

		System.out.println("");
	
		MobileCompanyDTO cst1 = or1.getMobCompany();
		System.out.print(cst1.getCompanyID()+" ");
		System.out.print(cst1.getComName()+" ");
		
		System.out.println("");
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveMobileCompanyMOdels();
		getMobileCompanyMOdels();
		
	}

}

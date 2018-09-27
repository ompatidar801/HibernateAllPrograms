package many2one7;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MobileCompanyMOdels
{
	static SessionFactory sf =new Configuration().configure().buildSessionFactory();
	static Session sn = sf.openSession();
	public static void saveMobileCompanyMOdels()
	{
		MobileCompanyDTO u = new MobileCompanyDTO();
		u.setCompanyID(958);
		u.setComName("Xiaomi");
		
		ModelsDTO co1 = new ModelsDTO();
		co1.setModelNO(444);
		co1.setModelName("A1");
		co1.setParentObject(u);
		
		ModelsDTO co2 = new ModelsDTO();
		co2.setModelNO(555);
		co2.setModelName("Redmi4");
		co2.setParentObject(u);
		
		ModelsDTO col3 = new ModelsDTO();
		col3.setModelNO(666);
		col3.setModelName("MiMAX");
		col3.setParentObject(u);
		
		Transaction tr = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(col3);
		tr.commit();
		
	}
	public static void getMobileCompanyMOdels()
	{
		
		ModelsDTO or1 = (ModelsDTO) sn.get(ModelsDTO.class,444);
		System.out.print(or1.getModelNO()+" ");
		System.out.print(or1.getModelName()+" ");

		System.out.println("");
	
		MobileCompanyDTO cst1 = or1.getParentObject();
		System.out.print(cst1.getCompanyID()+" ");
		System.out.print(cst1.getComName()+" ");
		
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		//saveMobileCompanyMOdels();
		getMobileCompanyMOdels();
		sn.close();
	}

}
